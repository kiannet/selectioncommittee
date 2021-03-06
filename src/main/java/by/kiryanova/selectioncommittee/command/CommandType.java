package by.kiryanova.selectioncommittee.command;

import by.kiryanova.selectioncommittee.command.admin.*;
import by.kiryanova.selectioncommittee.command.common.*;
import by.kiryanova.selectioncommittee.command.user.*;
import by.kiryanova.selectioncommittee.service.AdminService;
import by.kiryanova.selectioncommittee.service.DefaultReceiver;
import by.kiryanova.selectioncommittee.service.CommonService;
import by.kiryanova.selectioncommittee.service.UserService;

public enum CommandType {
    LOGIN(new LoginCommand(new UserService())),
    LOGOUT(new LogoutCommand(new DefaultReceiver())),
    SIGNUP(new SignupCommand(new UserService())),
    FIND_LIST(new FindListCommand(new CommonService())),
    PROFILE(new ProfileCommand(new UserService())),
    TO_LOGIN(new ToLoginCommand(new UserService())),
    TO_SIGNUP(new ToSigningUpCommand(new UserService())),
    TO_FACULTIES(new ToFacultiesCommand(new CommonService())),
    TO_UNIVERSITY(new ToUniversityCommand(new CommonService())),
    RESULTS(new ResultsCommand(new CommonService())),
    MORE_ABOUT_FACULTY(new MoreAboutFacultyCommand(new CommonService())),
    UPDATE_RESULTS(new UpdateResultsCommand(new CommonService())),
    CHANGE_LANGUAGE(new ChangeLanguageCommand()),
    DELETE(new DeleteProfileCommand(new UserService())),
    FORGOT_PASSWORD(new ForgotPasswordCommand(new UserService())),
    TO_CHANGE_PROFILE(new ToChangeProfileCommand(new UserService())),
    CHANGE_PROFILE(new ChangeProfileCommand(new UserService())),
    CHANGE_PASSWORD(new ChangePasswordCommand(new UserService())),
    TO_CHANGE_PASSWORD(new ToChangePasswordCommand(new UserService())),
    TO_HOME(new ToHomeCommand(new UserService())),
    ADMIN_PROFILE(new AdminProfileCommand(new UserService())),
    USERS(new UsersCommand(new UserService())),
    TO_ADD_ENROLLEE(new ToAddEnrolleeCommand(new CommonService())),
    ADD_ENROLLEE(new AddEnrolleeCommand(new UserService())),
    DELETE_USER(new DeleteUserCommand(new UserService())),
    BAN_USER(new BanUserCommand(new AdminService())),
    UNBAN_USER(new UnbanUserCommand(new AdminService())),
    TO_CHANGE_ADMIN_PROFILE(new ToChangeAdminProfileCommand(new UserService())),
    CHANGE_ADMIN_PROFILE(new ChangeAdminProfileCommand(new AdminService()));

    private Command command;

    CommandType(Command command){
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
