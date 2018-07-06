package jp.co.axiz.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.axiz.dao.UsersDao;
import jp.co.axiz.entity.Form;
import jp.co.axiz.entity.Header;
import jp.co.axiz.entity.Users;



@Controller
public class UserController {
	@Autowired
	HttpSession session;
	@Autowired
	UsersDao ud;

	//新規登録
	//registerInputへ
	@RequestMapping(value="/registerInput",method=RequestMethod.GET)
	public String register (@ModelAttribute("command") Form form, Model model) {
		return "registerInput";
	}

	@RequestMapping(value="/registerConfirm",method = RequestMethod.POST)
	public String registerConfirm(@ModelAttribute("command") Form form,Model model) {		//登録画面で入力後の処理だよ
		if((form.getRegisterid()==null || form.getRegistername()==null ||form.getRegisterpass()==null)||"".equals(form.getRegisterid())||"".equals(form.getRegistername())||"".equals(form.getRegisterpass())){
			model.addAttribute("msg", "いずれかの必須項目が未入力です");
			return "registerInput";
		}

		session.setAttribute("registername",form.getRegistername());
		session.setAttribute("registerid",form.getRegisterid());
		session.setAttribute("registerpass",form.getRegisterpass());		//確認画面で使うからセッションいれるよ
		return "registerConfirm";
	}

	@RequestMapping(value="/registerResult",method=RequestMethod.POST)
	public String registerResult(@ModelAttribute("command") Form form,Model model) {		//確認したよ
		if(form.getreRegisterpass().equals(session.getAttribute("registerpass"))) {//パスあってたら
			boolean success=ud.register((String)session.getAttribute("registername"),(String)session.getAttribute("registerid"),(String)session.getAttribute("registerpass"));	//登録するよ
			if(!success) {//登録失敗したら
				model.addAttribute("msg", "そのIDは既に別ユーザによって使われています");
				return "registerInput";
			}
			return "registerResult";
		}else {
			model.addAttribute("msg", "前画面で入力したパスワードと違います");
			return "registerConfirm";
		}
	}

	//masterMenu
	@RequestMapping(value="/masterMenu",method = RequestMethod.GET)//GETのときはただ遷移するよ！
	public String masterMenu(@ModelAttribute("command") Form fm, BindingResult bindingResult, Model model) {
		return "masterMenu";
	}

	//ログインページへの遷移
	@RequestMapping(value="/index",method = RequestMethod.GET)//GETのときはただ遷移するよ！
	public String index(@ModelAttribute("command") Form fm, BindingResult bindingResult, Model model) {
		return "index";
	}

//管理者によるアカウントの削除
	//アカウント管理ページへ遷移
	@RequestMapping(value="/deleteuser",method = RequestMethod.GET)//GETのときはただ遷移するよ！
	public String deleteuser(@ModelAttribute("command") Form fm, BindingResult bindingResult, Model model) {
		List<Users> list = ud.findAll();
		session.setAttribute("user", list);
		return "deleteUser";
	}
	//削除をクリックしたアカウントを表示させたい

	@RequestMapping(value="/deleteUserConfirm",method = RequestMethod.POST)
	public String deleteuserConfirm(@ModelAttribute("command") Form fm, BindingResult bindingResult, Model model) {

		String delete_user_id = fm.getUser_id();
		Users users = ud.findUser(delete_user_id);
		session.setAttribute("deleteUser", users);
		return "deleteUserConfirm";
	}

	@RequestMapping(value="/deleteUserResult",method = RequestMethod.POST)
	public String deleteuserResult(@ModelAttribute("command") Form fm, BindingResult bindingResult, Model model) {

		String delete_user_id = fm.getUser_id();
		String delete_user_name = fm.getName();
		ud.delete(delete_user_id);
		return "deleteUserResult";
	}


	//ヘッダー文字変更画面へ遷移
	@RequestMapping(value="/headerInput",method = RequestMethod.GET)//GETのときはただ遷移するよ！
	public String headerInput(@ModelAttribute("command") Form fm, BindingResult bindingResult, Model model) {
		List<Header> headerList = ud.findHeader();
		Header header = headerList.get(0);
		String headerText = header.getHeader_text();
		String subHeaderText = header.getSub_header_text();
		//プレースホルダーで表示する用にセッションにいれるよ
		session.setAttribute("headerText", headerText);
		session.setAttribute("subHeaderText", subHeaderText);
		return "headerInput";
	}


	//ヘッダー変更だよ
	@RequestMapping(value="/headerResult",method = RequestMethod.POST)
	public String headerResult(@ModelAttribute("command") Form fm, BindingResult bindingResult, Model model) {

		String header = fm.getHeader();
		String subHeader = fm.getSubHeader();
		ud.headerUpdate(header,subHeader);	//このメソッドでヘッダー文字変更するよ
		return "headerResult";
	}



}
