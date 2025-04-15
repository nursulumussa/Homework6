class FAQBotHandler extends SupportHandler {
    @Override
    public void handle(String issue) {
        Logger.log("FAQBotHandler trying to handle: " + issue);
        if (issue.equals("password_reset")) {
            Logger.log("[FAQBot] Handled " + issue);
        } else if (next != null) {
            next.handle(issue);
        } else {
            Logger.log("[FAQBot] Issue unresolved — escalate manually");
        }
    }
}
