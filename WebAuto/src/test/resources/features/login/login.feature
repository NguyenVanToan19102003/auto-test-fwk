@login
  Feature: Đăng nhập vào hệ thống
    Scenario: Người dùng đăng nhập thành công
      Given Người dùng mở trang đăng nhập
      When Người dùng nhập username "student"
      And Người dùng nhập password "Password123"
      And Người dùng bấm nút đăng nhập
      Then Người dùng đăng nhập thành công
      And Hiển thị text "Logged In Successfully"
      And Người dùng đăng xuất khỏi hệ thống