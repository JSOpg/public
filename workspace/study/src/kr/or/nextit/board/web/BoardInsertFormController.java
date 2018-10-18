package kr.or.nextit.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.nextit.common.web.IController;

public class BoardInsertFormController implements IController {

	@Override
	public boolean isRedirect() {

		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		return "/board/BoardInsertForm";
	}

}