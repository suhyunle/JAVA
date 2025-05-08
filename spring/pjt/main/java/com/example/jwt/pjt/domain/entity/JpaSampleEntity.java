package com.example.jwt.pjt.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "siat_jpa_sample_tbl")
public class JpaSampleEntity {

    @Id
    @Column(name = "user_id", length = 50, nullable = false)
    private String userId;

    @Column(name = "user_passwd", length = 50, nullable = false)
    private String passwd;

    @Column(name = "user_name", length = 100, nullable = false)
    private String name;

    @Column(name = "user_point", nullable = false)
    private Integer point;

    // 기본 생성자
    public JpaSampleEntity() {}

    // Builder 사용을 위한 생성자
    private JpaSampleEntity(String userId, String passwd, String name, Integer point) {
        this.userId = userId;
        this.passwd = passwd;
        this.name = name;
        this.point = point;
    }

    // Builder 패턴을 위한 내부 정적 클래스
    public static JpaSampleEntityBuilder builder() {
        return new JpaSampleEntityBuilder();
    }

    // Builder 패턴을 위한 내부 클래스
    public static class JpaSampleEntityBuilder {
        private String userId;
        private String passwd;
        private String name;
        private Integer point;

        public JpaSampleEntityBuilder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public JpaSampleEntityBuilder passwd(String passwd) {
            this.passwd = passwd;
            return this;
        }

        public JpaSampleEntityBuilder name(String name) {
            this.name = name;
            return this;
        }

        public JpaSampleEntityBuilder point(Integer point) {
            this.point = point;
            return this;
        }

        public JpaSampleEntity build() {
            return new JpaSampleEntity(userId, passwd, name, point);
        }
    }

    // Getter and Setter (필요한 경우 추가)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }
}
