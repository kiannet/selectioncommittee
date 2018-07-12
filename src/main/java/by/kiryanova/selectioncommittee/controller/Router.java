package by.kiryanova.selectioncommittee.controller;

public class Router {
    public enum RouteType {
        FORWARD, REDIRECT;
    }

    private String pagePath;
    private RouteType routeType = RouteType.FORWARD;

    public String getPagePath(){
        return  pagePath;
    }

    public void setPagePath(String pagePath) {
        this.pagePath = pagePath;
    }

    public RouteType getRouteType() { return routeType; }

    public void setRouteType(RouteType routeType) {
        if (routeType == null){
            this.routeType = RouteType.FORWARD;
        }
        this.routeType = routeType;
    }
}
