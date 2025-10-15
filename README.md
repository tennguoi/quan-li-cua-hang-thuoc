
# Hệ thống quản lý cửa hàng thuốc

## Tổng Quan Dự Án

Dự án này là một **Hệ Thống Quản Lý Cửa Hàng Thuốc** được phát triển để quản lý toàn bộ quy trình của cửa hàng thuốc. Hệ thống bao gồm các chức năng như quản lý thuốc, khách hàng, nhân viên, đơn hàng, chi tiết đơn hàng, thanh toán và khuyến mãi. Dự án sử dụng **Spring Boot** cho backend và **MySQL** cho cơ sở dữ liệu.

## Các Tính Năng

### 1. **Quản Lý Thuốc**:
- **Lấy danh sách thuốc**: Lấy dữ liệu thuốc từ DB.
- **Hiển thị danh sách thuốc**: Hiển thị thông tin thuốc.
- **Sắp xếp danh sách thuốc**: Sắp xếp theo tên hoặc giá.
- **Phân trang danh sách thuốc**: Hiển thị theo từng trang (10 bản ghi).
- **Thêm thuốc mới**: Thêm thông tin thuốc mới vào DB.
- **Cập nhật thuốc**: Cập nhật thông tin thuốc.
- **Xóa thuốc**: Xóa thuốc khỏi DB.
- **Tìm kiếm thuốc**: Tìm thuốc theo tên, loại, nhà cung cấp.

### 2. **Quản Lý Khách Hàng**:
- **Lấy danh sách khách hàng**: Lấy dữ liệu khách hàng từ DB.
- **Hiển thị danh sách khách hàng**: Hiển thị thông tin khách hàng.
- **Sắp xếp danh sách khách hàng**: Sắp xếp theo tên hoặc điểm thưởng.
- **Phân trang danh sách khách hàng**: Hiển thị theo từng trang (10 bản ghi).
- **Thêm khách hàng mới**: Thêm khách hàng mới vào DB.
- **Cập nhật khách hàng**: Cập nhật thông tin khách hàng.
- **Xóa khách hàng**: Xóa khách hàng khỏi DB.
- **Tìm kiếm khách hàng**: Tìm khách hàng theo tên, số điện thoại, loại khách hàng.

## Hướng Dẫn Cài Đặt

### 1. **Cài đặt môi trường**
Để chạy ứng dụng, bạn cần cài đặt các công cụ và phần mềm sau:
- **Java 11 hoặc cao hơn**: Để chạy ứng dụng Spring Boot.
- **MySQL**: Để lưu trữ dữ liệu và quản lý cơ sở dữ liệu.
- **Maven**: Để quản lý các phụ thuộc và biên dịch dự án (nếu sử dụng Maven).
- **IDE**: IntelliJ IDEA hoặc Eclipse để phát triển và triển khai ứng dụng.

### 2. **Clone Repository**
Clone dự án từ GitHub về máy tính của bạn:
```bash
git clone -b dev https://github.com/tennguoi/quan-li-cua-hang-thuoc.git
````

### 3. **Tạo cơ sở dữ liệu trong MySQL**
Tạo cơ sở dữ liệu **`pharmacy_manager`** trong MySQL:
```sql
CREATE DATABASE pharmacy_manager;
```
Sau đó, sao chép các câu lệnh SQL tạo bảng vào trong **MySQL Workbench** và **chạy** từng câu lệnh để tạo bảng.

### 4. **Cấu hình ứng dụng**
Để cấu hình ứng dụng **Spring Boot** kết nối với cơ sở dữ liệu **MySQL**, bạn cần thay đổi một số thông tin trong file cấu hình **`application.properties`**.
#### 4.1 **Cấu hình kết nối cơ sở dữ liệu**
1. Mở file **`application.properties`** trong thư mục **`src/main/resources`**.
2. Thêm hoặc thay đổi các thông tin kết nối đến cơ sở dữ liệu MySQL của bạn. Dưới đây là ví dụ cấu hình kết nối:
```properties
# Cấu hình kết nối MySQL
spring.datasource.url=jdbc:mysql://localhost:3306/pharmacy_manager
spring.datasource.username=root         # Thay bằng tên người dùng của bạn
spring.datasource.password=your_password  # Thay bằng mật khẩu của bạn
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```
#### 4.2 **Cấu hình cổng ứng dụng (nếu cần)**
Nếu bạn muốn thay đổi cổng mà ứng dụng chạy, bạn có thể thêm vào **`application.properties`**:
```properties
server.port=8081  # Thay đổi cổng từ 8080 thành 8081
```
### 5. **Cài đặt phụ thuộc**
Nếu bạn sử dụng **Maven**, chạy lệnh sau để tải các phụ thuộc cần thiết:
```bash
mvn clean install
```
Nếu bạn sử dụng **Gradle**, chạy lệnh sau:
```bash
gradle build
```
### 6. **Chạy ứng dụng**
Sau khi cài đặt và cấu hình xong, bạn có thể chạy ứng dụng **Spring Boot** bằng lệnh:
```bash
mvn spring-boot:run
```
Hoặc nếu bạn sử dụng IDE, chỉ cần chạy ứng dụng từ IDE của bạn.

