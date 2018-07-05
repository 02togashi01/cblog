package jp.co.axiz.controller;

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



@Controller
public class UserController {
	@Autowired
	HttpSession session;
	@Autowired
	UsersDao ud;

	@RequestMapping(value="/index",method = RequestMethod.GET)//GETのときはただ遷移するよ！
	public String index(@ModelAttribute("command") Form fm, BindingResult bindingResult, Model model) {
		return "index";
	}//ログインページへの遷移

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
				model.addAttribute("msg", "登録失敗しました。そのIDは既に他のユーザによって使用されています");
				return "registerInput";
			}
			return "registerResult";
		}else {
			model.addAttribute("msg", "前画面で入力したパスワードと一致しません");
			return "registerConfirm";
		}
	}
}
