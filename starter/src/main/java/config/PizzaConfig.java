package config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "pizza")
public class PizzaConfig {
    private String sauce;
    private String topping;
    private String crust;

    public PizzaConfig() {
        this.sauce = "tomato";
        this.topping = "salami";
        this.crust = "medium";
    };

    public PizzaConfig(String sauce, String topping, String crust) {
        this.sauce = sauce;
        this.topping = topping;
        this.crust = crust;
    }

    public String getSauce() {
        return this.sauce;
    }

   public void setSauce(String sauce) {
        this.sauce = sauce;
   }

    public String getTopping() {
        return this.topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public String getCrust() {
        return this.crust;
    }

    public void setCrust(String crust) {
        this.crust = crust;
    }



}
