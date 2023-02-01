package nextstep.member;

public enum MemberRole {
    NORMAL, ADMIN;

    public boolean isAdmin() {
        return this.equals(MemberRole.ADMIN);
    }
}
