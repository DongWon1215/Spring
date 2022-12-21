package com.app.board.security;

import com.app.board.Domain.BoardMember;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
public class CustomUser extends User {


    // 추가적인 회원의 정보
    private BoardMember boardmember;

    public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities, BoardMember boardmember) {
        super(username, password, authorities);
        this.boardmember = boardmember;
    }

    public CustomUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, BoardMember boardmember) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.boardmember = boardmember;
    }

    @Override
    public String toString() {
        return "CustomUser{" +
                "member=" + boardmember +
                '}';
    }
}
