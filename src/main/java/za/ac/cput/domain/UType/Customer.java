/*
 * Customer.java
 * Author: Justin Angelo Karoles (222008237)
 * Date: August 2025
 */

package za.ac.cput.domain.UType;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import za.ac.cput.domain.User;

@Entity
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "user_id")
public class Customer extends User {

    private String paymentMethod;
    private double amount;

    protected Customer() {
        
    }

    public Customer(Builder builder) {
        super(builder.firstName, builder.lastName, builder.email, builder.password, builder.role);
        this.paymentMethod = builder.paymentMethod;
        this.amount = builder.amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "userId=" + getUserId() +
                ", email='" + getEmail() + '\'' +
                ", role='" + getRole() + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", amount=" + amount +
                '}';
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private String role;
        private String paymentMethod;
        private double amount;

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

        public Builder setPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Builder setAmount(double amount) {
            this.amount = amount;
            return this;
        }

        public Builder copy(Customer customer) {
            this.firstName = customer.getFirstName();
            this.lastName = customer.getLastName();
            this.email = customer.getEmail();
            this.password = customer.getPassword();
            this.role = customer.getRole();
            this.paymentMethod = customer.getPaymentMethod();
            this.amount = customer.getAmount();
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }
}
