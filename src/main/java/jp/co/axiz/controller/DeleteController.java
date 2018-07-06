package jp.co.axiz.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.axiz.dao.UsersDao;
import jp.co.axiz.entity.Form;
import jp.co.axiz.entity.Users;

@Controller
public class DeleteController {
	@Autowired
	UsersDao ud;

	@Autowired
	HttpSession session;

//退会処理
	//ログインしているユーザのid,nameを表示させたい！
	@RequestMapping(value="/userDelete",method=RequestMethod.GET)
	public String select (@ModelAttribute("command") Form form, Model model) {

		session.setAttribute("id",form.getUser_id());
		session.setAttribute("user_name",form.getName());
		session.setAttribute("pass",form.getPass());		//確認画面で使うからセッションいれるよ

		return "userDelete";
	}

//	@RequestMapping(value="/userDeleteResult",method=RequestMethod.POST)
//	public String deleteConfirm(@ModelAttribute("command") Form form, Model model) {
//		//ログインしているユーザの情報をテーブルから削除
//		try {
//			ud.deleteById(id);
//			session.removeAttribute("defo_id");
//			return "deleteResult";
//		}catch(Exception e){
//			return "delete";
//		}
//	}

//管理人によるアカウント削除
	@RequestMapping(value="/deleteConfirm",method=RequestMethod.POST)
	public String delete1 (@ModelAttribute("command") Form form, Model model) {	//管理人からの削除画面

		String id=form.getUser_id();
		String pass=form.getPass();
		if((form.getUser_id()==null ||form.getPass()==null) || "".equals(form.getUser_id())||"".equals(form.getPass())) {
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

}
