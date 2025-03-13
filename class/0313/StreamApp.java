public class StreamApp {
    private String name;
    private int price;
    private String location;
    private int year;

    // 생성자를 private으로 제한하고 Builder를 통해 객체 생성
    private Product(Builder builder) {
        this.name = builder.name;
        this.price = builder.price;
        this.location = builder.location;
        this.year = builder.year;
    }

    // Getter 메소드
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getLocation() {
        return location;
    }

    public int getYear() {
        return year;
    }

    // Builder 클래스
    public static class Builder {
        private String name;
        private int price;
        private String location;
        private int year;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder price(int price) {
            this.price = price;
            return this;
        }

        public Builder location(String location) {
            this.location = location;
            return this;
        }

        public Builder year(int year) {
            this.year = year;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }

    // toString 메소드
    @Override
    public String toString() {
        return String.format("Product{name='%s', price=%d, location='%s', year=%d}", 
                             name, price, location, year);
    }
}
