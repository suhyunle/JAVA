class OopApp {
    private String name;
    private String address;
    private String year;

    // 기본 생성자
    public OopApp() {
        this.name = "이름 미정";
        this.address = "주소 미정";
        this.year = "입학 연도 미정";
    }

    // 생성자 오버로딩 (모든 정보 입력)
    public OopApp(String name, String address, String year) {
        this.name = name;
        this.address = address;
        this.year = year;
    }

    // Getter & Setter (캡슐화 적용)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getYear() { return year; }
    public void setYear(String year) { this.year = year; }

    // 개인 정보 출력
    public String perInfo() {
        return "이름: " + name + ", 주소: " + address;

    public String stuInfo() {
        return "입학 연도: " + year;
    }
    @Override
    public String toString() {
        return "학생 정보: [이름=" + name + ", 주소=" + address + ", 입학 연도=" + year + "]";
    }
}
