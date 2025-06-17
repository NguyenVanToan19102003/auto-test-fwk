# Mô tả chức năng/chủ đề tổng quát cần test.
@login
Feature: Đăng nhập vào hệ thống
  # Một tình huống hoặc kịch bản cụ thể để kiểm thử chức năng đó.
  Scenario: Người dùng đăng nhập thành công
    # Điều kiện ban đầu, trạng thái ban đầu trước khi thực hiện hành động.
    Given Người dùng mở trang đăng nhập
    # Hành động, thao tác được thực hiện trong kịch bản.
    When Người dùng nhập username "student"
    And Người dùng nhập password "Password123"
    And Người dùng bấm nút đăng nhập
    # Kết quả hoặc trạng thái mong muốn sau khi hành động được thực hiện.
    Then Người dùng đăng nhập thành công
    And Điều hướng đến trang chủ
    # Dùng để nối thêm các bước cùng loại (ví dụ nhiều hành động hoặc nhiều điều kiện).