class JuniorSupportHandler extends SupportHandler {
    @Override
    public void handle(String issue) {
        Logger.log("JuniorSupportHandler trying to handle: " + issue);
        if (issue.equals("refund_request") || issue.equals("billing_issue")) {
            Logger.log("[JuniorSupport] Handled " + issue);
        } else if (next != null) {
            next.handle(issue);
        } else {
            Logger.log("[JuniorSupport] Issue unresolved — escalate manually");
        }
    }
}
