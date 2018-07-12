package by.kiryanova.selectioncommittee.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class FooterTag extends TagSupport {

    @Override
    public int doStartTag() throws JspException {
        String footer = "<p class=\"copyright\" >&copy; Copyright 2018 Minsk - All rights reserved. Template by A.Kiryanova.<p>";

        try {
            JspWriter out = pageContext.getOut();
            out.write(footer);
        } catch (IOException e) {
            throw new JspException("Error footer tag: " + e.getMessage());
        }

        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException{
        return EVAL_PAGE;
    }
}
