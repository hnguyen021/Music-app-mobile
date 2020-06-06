Thư mục gồm 1 folder htdoc,1 project android,1 file phpmyadmin,1file word report
1 Cấu hình lại xampp là port 8888 rồi copy thư mục htdoc đấy thay thế vào thư mục htdoc của bạn
2 Upload file bd_music.sql lên phpmyadmin của Xampp
3 Mở project MyApplication4 bằng Android Studio mới nhất và đồng bộ lại với app
4 Vô mục APIservice.java của phần Service cầu hình lại sao cho đúng với địa chỉ IP trên máy bạn
5 thay đổi hoặc thêm phần (http://"ĐỊA CHỈ IP TRÊN MÁY BẠN":8888/) trước các mục "linkbaihat,hinhanh,icon"... trong bd_music.sql
 --VÍ DỤ Ở 1 DÒNG TRÊN BẢNG baihat là:(1, 1, 1, 1, 'Lá Xa Lìa Cành', 'http://192.168.1.4:8888/upload/xalaliacanh.jpg\r\n', 'Lê Bảo Bình', 'http://192.168.1.4:8888/upload/lebaobinh_xalaliacanh.mp3\r\n', 9),
   Bạn hãy thay thế địa chỉ ip trên máy vào 'http://192.168.1.4:8888/upload/xalaliacanh.jpg\r\n' ==>'http://ĐỊA CHỈ NHÀ BẠN:8888/upload/xalaliacanh.jpg\r\n'
6.Ấn run project MyApplication4
