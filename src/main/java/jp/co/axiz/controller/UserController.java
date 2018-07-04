package jp.co.axiz.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.axiz.dao.UsersDao;
import jp.co.axiz.entity.Form;
import jp.co.axiz.entity.Users;



@Controller
public class UserController {
	@Autowired
	HttpSession session;
	@Autowired
	UsersDao ud;


	@RequestMapping(value="/menu",method=RequestMethod.GET)
	public String menu(@ModelAttribute("command") Form form, Model model) {
		Users user = (Users) session.getAttribute("controller");
		if(user.getRole()==null) {
			return "top";
		}
		Integer role = user.getRole();
		if(role==1) {//管理人
			//管理人メニューで一般ユーザを一覧表示させるので取得するメソッド呼ぶ
			List<Users> list = ud.findAll();
			session.setAttribute("alluser", list);
			return "mastermenu";
		}else {	//パンピー
			return "menu";
		}
	}



	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String register (@ModelAttribute("command") Form form, Model model) {
		return "register";
	}

	@RequestMapping(value="/registerConfirm",method = RequestMethod.POST)
	public String registerConfirm(@ModelAttribute("command") Form form,Model model) {		//登録画面で入力後の処理だよ
		if((form.getName()==null || form.getId()==null ||form.getPass()==null)||"".equals(form.getName())||"".equals(form.getId())||"".equals(form.getPass())){
			model.addAttribute("msg", "必須項目が未入力です！！");
			return "register";
		}
		session.setAttribute("registername",form.getName());
		session.setAttribute("registerid",form.getId());
		session.setAttribute("registerpass",form.getPass());		//確認画面で使うからセッションいれるよ
		return "registerConfirm";
	}

	@RequestMapping(value="/registerResult",method=RequestMethod.POST)
	public String registerResult(@ModelAttribute("command") Form form,Model model) {		//確認したよ
		if(form.getRePass().equals(session.getAttribute("registerpass"))) {//パスあってたら
			boolean success=ud.register((String)session.getAttribute("registername"),(String)session.getAttribute("registerid"),(String)session.getAttribute("registerpass"));	//登録するよ
			if(!success) {//登録失敗したら
				model.addAttribute("msg", "登録失敗しました。そのIDは既に他のユーザによって使用されています");
				return "register";
			}
			return "registerResult";
		}else {
			model.addAttribute("msg", "前画面で入力したパスワードと一致しません");
			return "registerConfirm";
		}
	}


	@RequestMapping(value="/updateInput",method=RequestMethod.GET)
	public String updateInput (@ModelAttribute("command") Form form, Model model) {
		return "updateInput";
	}
	@RequestMapping(value="/deleteInput",method=RequestMethod.GET)
	public String deleteInput (@ModelAttribute("command") Form form, Model model) {
		return "deleteInput";
	}


	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update1 (@ModelAttribute("command") Form form, Model model) {//管理人から入力経て遷移
		if((form.getId()==null ||form.getPass()==null) || "".equals(form.getId())||"".equals(form.getPass())) {
			model.addAttribute("msg", "必須項目が未入力です！！");
			return "updateInput";
		}
		Users user = ud.findUser(form.getId(), form.getPass());	//ユーザー検索
		if(user==null) {
			model.addAttribute("msg", "IDもしくはPASSが間違っています");
			return "updateInput";

		}
		if(user.getRole()==1) {
			model.addAttribute("msg", "そのユーザーの情報は変更できません！");
			return "updateInput";
		}else {
			session.setAttribute("updateuser", user);
			return "update";
		}
	}

	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String update2 (@ModelAttribute("command") Form form, Model model) {	//一般ユーザのメニューから更新遷移
		Users user =(Users) session.getAttribute("controller");
		session.setAttribute("updateuser", user);
		return "update";
	}


	@RequestMapping(value="/updateConfirm",method=RequestMethod.POST)
	public String updateConfirm(@Validated @ModelAttribute("command") Form form, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "update";
		}

		String newName=form.getNewName();
		String newId=form.getNewId();
		String newPass=form.getNewPass();
		Users before = (Users) session.getAttribute("updateuser");
		Users after = new Users(newId,newPass,newName);
		session.setAttribute("afteruser", after);
		if(newName.equals(before.getName()) && newId.equals(before.getId()) && newPass.equals(before.getPass())) {	//もしなんも変わってないなら
			model.addAttribute("msg", "1項目以上変更してください");
			return "update";
		}
		if(before.getPass().equals(newPass)) {//pass変更されてないなら
			session.setAttribute("pass", newPass);
		}else {
			session.setAttribute("pass", "");
		}
		return "updateConfirm";
	}

	@RequestMapping(value="/updateResult",method=RequestMethod.POST)
	public String updateResult(@ModelAttribute("command") Form form, Model model) {

		String rePass=form.getRePass();
		Users newUser = (Users) session.getAttribute("afteruser");
		Users oldUser = (Users) session.getAttribute("updateuser");
		String oldId = oldUser.getId();
		String newName=newUser.getName();
		String newId=newUser.getId();
		String newPass=newUser.getPass();
		if(!(rePass.equals(newPass))) {
			model.addAttribute("msg", "前画面で入力したパスワードと一致しません！");
			return "updateConfirm";
		}

		//更新！！
		ud.update(newId,newPass,newName,oldId);
		Users users = ud.findUser(newId, newPass);
		Users u=(Users) session.getAttribute("controller");
		if(u.getRole()==1) {//変更者が管理人なら
			return "updateResult";
		}
		session.setAttribute("controller", users);
		return "updateResult";
	}


	@RequestMapping(value="/deleteConfirm",method=RequestMethod.POST)
	public String delete1 (@ModelAttribute("command") Form form, Model model) {	//管理人からの削除画面

		String id=form.getId();
		String pass=form.getPass();
		if((form.getId()==null ||form.getPass()==null) || "".equals(form.getId())||"".equals(form.getPass())) {
			model.addAttribute("msg", "必須項目が未入力です！！");
			return "deleteInput";
		}
		Users deleteuser = ud.findUser(id,pass);

		if(deleteuser==null) {
			model.addAttribute("msg", "IDもしくはPASSが間違っています");
			return "deleteInput";
		}
		if(deleteuser.getRole()==1) {
			model.addAttribute("msg", "そのユーザーの情報は変更できません！");
			return "deleteInput";
		}else {
			session.setAttribute("deleteuser", deleteuser);
			return "deleteConfirm";
		}
	}


	@RequestMapping(value="/deleteConfirm",method=RequestMethod.GET)
	public String delete2 (@ModelAttribute("command") Form form, Model model) {	//一般ユーザのメニューから更新遷移
		Users user =(Users) session.getAttribute("controller");
		session.setAttribute("deleteuser", user);
		return "deleteConfirm";
	}


	@RequestMapping(value="/deleteResult",method=RequestMethod.POST)
	public String deleteResult(@ModelAttribute("command") Form form, Model model) {
		String id=form.getId();
		ud.delete(id);		//削除！！
		return "deleteResult";
	}







}
