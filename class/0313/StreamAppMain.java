import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // 더미 데이터 10개 생성
        List<Product> products = Arrays.asList(
            new Product.Builder().name("더미네이터1").price(50000).location("부산").year(2025).build(),
            new Product.Builder().name("더미네이터2").price(75000).location("서울").year(2024).build(),
            new Product.Builder().name("더미네이터3").price(30000).location("부산").year(2025).build(),
            new Product.Builder().name("더미네이터4").price(90000).location("대구").year(2025).build(),
            new Product.Builder().name("더미네이터5").price(45000).location("부산").year(2023).build(),
            new Product.Builder().name("더미네이터6").price(120000).location("인천").year(2025).build(),
            new Product.Builder().name("더미네이터7").price(20000).location("부산").year(2025).build(),
            new Product.Builder().name("더미네이터8").price(55000).location("광주").year(2025).build(),
            new Product.Builder().name("더미네이터9").price(150000).location("부산").year(2024).build(),
            new Product.Builder().name("더미네이터10").price(80000).location("서울").year(2025).build()
        );

        // 1. 2025년에 생산된 모든 제품을 찾아 출력 (가격 오름차순 정렬)
        System.out.println("✅ 2025년에 생산된 제품 (가격 오름차순):");
        products.stream()
                .filter(p -> p.getYear() == 2025)
                .sorted(Comparator.comparingInt(Product::getPrice))
                .forEach(System.out::println);

        System.out.println();

        // 2. 생산지역이 부산인 제품 출력
        System.out.println("✅ 생산지역이 부산인 제품:");
        products.stream()
                .filter(p -> p.getLocation().equals("부산"))
                .forEach(System.out::println);

        System.out.println();

        // 3. 제품 가격이 가장 높은 제품 정보 출력
        System.out.println("✅ 제품 가격이 가장 높은 제품:");
        products.stream()
                .max(Comparator.comparingInt(Product::getPrice))
                .ifPresent(System.out::println);

        System.out.println();

        // 4. 제품 이름을 오름차순으로 출력
        System.out.println("✅ 제품 이름 (오름차순):");
        products.stream()
                .map(Product::getName)
                .sorted()
                .forEach(System.out::println);
    }
}
