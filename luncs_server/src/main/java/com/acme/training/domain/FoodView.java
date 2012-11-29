package com.acme.training.domain;

public class FoodView {
    
        private String name;
        private int id;
        private int price;
        
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public int getPrice() {
            return price;
        }
        public void setPrice(int price) {
            this.price = price;
        }
        
        public FoodView() {}
        
        public FoodView(String name, int id, int price) {
            this.name = name;
            this.id = id;
            this.price = price;
        }
        @Override
        public String toString() {
            return "FoodView [name=" + name + ", id=" + id + ", price=" + price + "]";
        }
        
        
}
