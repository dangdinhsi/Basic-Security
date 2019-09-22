package com.siddd00474.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Account {
    @Id
    @Email(message = "Không đúng định dạng email")
    @Size(min = 7, max = 30,message = "Tối thiểu 7 kí tự, tối đa 30 kí tự")
    private String email;
    @Size(min = 6, message = "Mật khẩu tối thiểu 6 kí tự")
    private String password;
    @NotNull
    private String name;
    private long createdAt;
    private long updatedAt;
    private long deletedAt;
    private int status;
    private String role;

    public enum Role {
        ADMIN("admin"), USER("user");

        private String value;

        Role(String user) {
            this.value = user;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public long getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(long deletedAt) {
        this.deletedAt = deletedAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
