package by.kiryanova.selectioncommittee.command;

import by.kiryanova.selectioncommittee.logic.DefaultReceiver;
import by.kiryanova.selectioncommittee.logic.UniversityReceiver;
import by.kiryanova.selectioncommittee.logic.UserReceiver;

public enum CommandType {
    LOGIN(new LoginCommand(new UserReceiver())),
    LOGOUT(new LogoutCommand(new DefaultReceiver())),
    SIGNUP(new SignupCommand(new UserReceiver())),
    FINDLIST(new FindListCommand(new UniversityReceiver())),
    PROFILE(new ProfileCommand(new UserReceiver())),
    TOLOGIN(new ToLoginCommand(new UserReceiver())),
    TOSIGNUP(new ToSigningUpCommand(new UserReceiver())),
    TOFACULTIES(new ToFacultiesCommand(new UniversityReceiver())),
    TOUNIVERSITY(new ToUniversityCommand(new UniversityReceiver())),
    RESULTS(new ResultsCommand(new UniversityReceiver())),
    MOREABOUTFACULTY(new MoreAboutFacultyCommand()),
    UPDATERESULTS(new UpdateResultsCommand(new UniversityReceiver())),
    CHANGELANGUAGE(new ChangeLanguageCommand()),
    DELETE(new DeleteProfileCommand(new UserReceiver())),
    FORGOTPASSWORD(new ForgotPasswordCommand(new UserReceiver())),
    TOCHANGEPROFILE(new ToChangeProfileCommand(new UserReceiver())),
    CHANGEPROFILE(new ChangeProfileCommand(new UserReceiver()));

    private Command command;

    CommandType(Command command){
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
