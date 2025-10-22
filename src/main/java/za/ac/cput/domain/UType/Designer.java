package za.ac.cput.domain.UType;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import za.ac.cput.domain.User;

@Entity
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "user_id")

public class Designer extends User {
    private String portfolioURL;

    protected Designer() {

    }

    public Designer(Builder builder) {
        super(builder.firstName, builder.lastName, builder.email, builder.password, builder.role);
        this.portfolioURL = builder.portfolioURL;
    }

    public String getPortfolioURL() {
        return portfolioURL;
    }

    @Override
    public String toString() {
        return "Designer{" +
                "portfolioURL='" + portfolioURL + '\'' +
                '}';
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private String role;
        private String portfolioURL;

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setRole(String role) {
            this.role = role;
            return this;
        }

        public Builder setPortfolioURL(String portfolioURL) {
            this.portfolioURL = portfolioURL;
            return this;
        }

        public Builder copy(Designer designer) {
            this.firstName = designer.getFirstName();
            this.lastName = designer.getLastName();
            this.email = designer.getEmail();
            this.password = designer.getPassword();
            this.role = designer.getRole();
            this.portfolioURL = designer.portfolioURL;
            return this;
        }
        public Designer build() {
            return new Designer(this);
        }
    }


}
