package com.example.appdoctruyentranh.database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.appdoctruyentranh.model.AppTruyen;
import com.example.appdoctruyentranh.model.TaiKhoan;

public class databasedoctruyen extends SQLiteOpenHelper {
    private static String DATABASE_NAME = "doctruyen";
    private static String TABLE_TAIKHOAN = "taikhoan";
    private static String ID_TAI_KHOAN = "idtaikhoan";
    private static String TEN_TAI_KHOAN = "tentaikhoan";
    private static String MAT_KHAU = "matkhau";
    private static String PHAN_QUYEN = "phanquyen";
    private static String EMAIL = "email";
    private static int VERSION = 1;

    private static String TABLE_TRUYEN = "truyen";
    private static String ID_TRUYEN = "idtruyen";
    private static String TEN_TRUYEN = "tieude";
    private static String NOI_DUNG = "noidung";
    private static String IMAGE = "anh";


    private Context context;

    private String SQLQuery = "CREATE TABLE "+ TABLE_TAIKHOAN +" ( "+ID_TAI_KHOAN+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +TEN_TAI_KHOAN+" TEXT UNIQUE, "
            +MAT_KHAU+" TEXT, "
            +EMAIL+" TEXT, "
            + PHAN_QUYEN+" INTEGER) ";

    private String SQLQuery1 = "CREATE TABLE "+ TABLE_TRUYEN +" ( "+ID_TRUYEN+" integer primary key AUTOINCREMENT, "
            +TEN_TRUYEN+" TEXT UNIQUE, "
            +NOI_DUNG+" TEXT, "
            +IMAGE+" TEXT, "+ID_TAI_KHOAN+" INTEGER , FOREIGN KEY ( "+ ID_TAI_KHOAN +" ) REFERENCES "+
            TABLE_TAIKHOAN+"("+ID_TAI_KHOAN+"))";
    //tài khoản có sẵn đầu là admin, sau là người dùng lập sẵn
    private String SQLQuery2 = "INSERT INTO TaiKhoan VAlUES (null,'admin','admin','admin@gmail.com',2)";
    private String SQLQuery3 = "INSERT INTO TaiKhoan VAlUES (null,'vietanh','vietanh','vietanh@gmail.com',1)";
    private String SQLQuery4 = "INSERT INTO truyen VALUES (null,'Tinh Thần Biến','Phần 1:\n" +
            "\n" +
            "Ngày xửa ngày xưa, có một con Rùa và một con Thỏ sống trong một khu rừng xinh đẹp và yên tĩnh. Ngày ngày chúng vui chơi với nhau như hai người bạn thân. Một hôm, Thỏ và Rùa cãi nhau xem ai nhanh hơn. Rồi chúng quyết định giải quyết việc tranh luận bằng một cuộc thi chạy đua. Thỏ và Rùa đồng ý lộ trình và bắt đầu cuộc đua. Thỏ xuất phát nhanh như tên bắn và chạy thục mạng rất nhanh, khi thấy rằng mình đã khá xa Rùa, Thỏ nghĩ nên nghỉ cho đỡ mệt dưới một bóng cây xum xuê lá bên vệ đường. Vì quá tự tin vào khả năng giành chiến thắng của mình, Thỏ ngồi dưới bóng cây và nhanh chóng ngủ thiếp đi. Rùa chạy mãi rồi cũng đến nơi, thấy Thỏ đang ngủ ngon giấc Rùa từ từ vượt qua Thỏ và về đích trước Thỏ. Khi Thỏ thức dậy thì rùa đã đến đích và trở thành người chiến thắng. Lúc này Thỏ biết mình đã thua cuộc vì quá tự tin vào khả năng của mình, còn Rùa chiến thắng vì kiên trì bám đuổi mục tiêu và làm việc hết sức trong khả năng của mình, cộng với một chút may mắn và giành chiến thắng.\n" +
            "\n" +
            "Ý nghĩa câu chuyện phần 1: truyện giáo dục đức tính kiên trì, siêng năng, nhẫn nại. Những người nhanh nhẹn nhưng cẩu thả trong suy nghĩ cuối cùng cũng sẽ bị đánh bại bởi người kiên nhẫn, siêng năng dù họ chậm hơn rất nhiều.\n" +
            "\n" +
            "Phần 2:Quyết Tâm\n" +
            "\n" +
            "Trong tiết đông lạnh giá hoa tuyết lất phất bay, nhiệt độ hạ xuống thấp mặt sông đều đã kết tinh thành băng nhưng hai đại hán hai thân trên vẫn cởi trần không hề mặc thêm gì cả. Nhưng điều làm cho mọi người kinh hãi chính là bên hai đại hán bất ngờ xuất hiện một lão hổ hung mãnh.Lão hổ toàn thân hồng sắc rực lửa, thân thể dài khoảng hơn hai thước, đuôi ve vẩy trong không trung khiến không khí nhất thời xao động, từ đôi mắt hổ phát xuất tia hàn khí. Lão hổ chính thị được gọi là \n"+
            "/n"+
            "Ảnh minh họa.','https://thuvienanime.com/wp-content/uploads/2021/09/tan-vu.jpeg',1)";
    private String SQLQuery5 = "INSERT INTO truyen VALUES (null,'Trấn Đông Vương','Lúc đó từ Trấn Đông vương phủ xuất hiện hai đại hán giống như hai đại hán cởi trần đang đứng trước cửa, chỉ phân biệt nhờ vào liệt hổ hung mãnh họ dẫn theo, rồi họ thay đổi vị trí với nhau. Bên ngoài phủ đệ, dù là hào gia quý tộc hay là bình dân du dân tại Viêm kinh thành đều tự giác tránh đường đến gần Trấn Đông vương phủ.Trong một tiểu viện u tĩnh tại Trấn Đông vương phủ.Một trung niên nhân vận thanh y đang ngồi trên thạch kỷ, bên cạnh là một tiểu nam hài khả ái. Đứng trước mặt trung niên nhân là mười hai người, lão giả có, mĩ phụ có, hoặc là thanh niên cũng có…nhưng cả mười hai người này đều có điểm chung là đều mặc tử y.\n" +
            "\n" +
            "– Phụ vương, sao người lại gọi nhiều vị lão sư vậy?\n" +
            "\n" +
            "Hài tử Tần Vũ mới sáu tuổi đang ngồi trên đùi phụ thân, trong tay đang nghịch tuyết cầu, nghi hoặc nhìn phụ thân Tần Đức.\n" +
            "\n" +
            "Tần Đức hòa ái nhìn nhi tử Tần Vũ, khẽ xoa đầu đoạn hướng về phía mười hai người kia điềm đạm nói: \n" +
            "\n" +
            "Các vị dậy dỗ Vũ nhi một khoảng thời gian, cũng đã tốn công không ít, không cần phải cân nhắc nữa, xin cho ta biết nhận xét. \n" +
            "\n" +
            "Mười hai người kia nhìn nhau, sau cùng một lão giả có chòm râu bạc trắng tiến lên một bước, cung kính nói: \n" +
            "\n" +
            "- Bẩm vương gia, chúng tại hạ đã quan sát về các phương diện, nhận thấy tam điện hạ đối với kỳ môn xảo kĩ rất có hứng thú, tuy nhiên đối với các vấn đề quyền thế không hề có chút hứng thú. Căn cứ vào những điều đó có thể phán đoán rằng tam điện hạ khó có khả năng phù hợp trở thành một người có vị trí cao.\n" +
            "\n" +
            "Chỉ bằng vào vài ngày tiếp xúc với nam hài họ đã có thể đưa ra phán đoán như vậy, tựa như chém đinh chặt sắt. Tất nhiên Tần Đức trong lòng không thể hoài nghi được.Tần Đức thở dài một tiếng, nhìn sang hài tử Tần Vũ ngây thơ chưa biết gì, cười khổ nói\n" +
            "\n" +
            "- Ta hiểu, Vũ nhi giống hệt mẹ nó, đối với quyền thế của thế tục không có một tia hứng thú, tuy nhiên nó sinh ra đã được định sẵn để trở thành…\n" +
            "\n" +
            "Tần Đức đang nói đột nhiên ngừng lại, quay về phía sau phất tay nói:\n" +
            "\n" +
            "– Thời gian qua đã làm phiền các ngươi nhiều, các người có thể li khai vương phủ. Vương gia, chúng tại hạ cáo từ!\n" +
            "\n" +
            "- Lúc đó từ Trấn Đông vương phủ xuất hiện hai đại hán giống như hai đại hán cởi trần đang đứng trước cửa, chỉ phân biệt nhờ vào liệt hổ hung mãnh họ dẫn theo, rồi họ thay đổi vị trí với nhau.\n" +
            "\n" +
            "– Bên ngoài phủ đệ, dù là hào gia quý tộc hay là bình dân du dân tại Viêm kinh thành đều tự giác tránh đường đến gần Trấn Đông vương phủ.\n" +
            "\n" +
            "- Trong một tiểu viện u tĩnh tại Trấn Đông vương phủ.\n" +
            "\n" +
            "Ảnh minh họa.','https://static.8cache.com/cover/o/eJzLyTDV1zXOC0rJynfNK_BO1g9zCvRL8sgOdQn01HeEguyAcn2vlLzQAKeKYtcKA_1iAwDnUhFa/tinh-than-bien.jpg',1)";
    private String SQLQuery6 = "INSERT INTO truyen VALUES (null,'Một trung niên','bên cạnh là một tiểu nam hài khả ái. Đứng trước mặt trung niên nhân là mười hai người, lão giả có, mĩ phụ có, hoặc là thanh niên cũng có…nhưng cả mười hai người này đều có điểm chung là đều mặc tử y.\n" +
            "\n" +
            "- Phụ vương, sao người lại gọi nhiều vị lão sư vậy?\n" +
            "\n" +
            "Tần Vũ trong lòng rất thắc mắc, nhưng nó vốn là đứa trẻ rất thông minh nên không tiếp tục làm phiền phụ thân.\n" +
            "\n" +
            "Từ nhỏ Tần Vũ đã mất mẫu thân, trong lòng nó thì phụ thân là trọng yếu nhất, ngoài ra còn có hai ca ca nữa. Rất lâu sau đó, Tần Đức vẫn ngồi như vậy và Tần Vũ cũng tiếp tục ngồi trên đùi của cha.\n" +
            "\n" +
            "Đột nhiên, một tiếng hạc vang lên.\n" +
            "\n" +
            "Chỉ thấy từ không trung một đạo bạch sắc tiên hạc bay tới, cưỡi phía trên là một trung niên tuấn nhã mang vẻ tiên phong đạo cốt, từ từ điều khiển tiên hạc hạ xuống trang viện.\n" +
            "\n" +
            "Phong huynh, Vũ nhi đan điền có vấn đề, huynh phải giúp ta tìm ra giải pháp… Tần Đức nhìn sang người trung niên, lo âu nói.\n" +
            "\n" +
            "Phong Ngọc Tử nhìn sang Tần Đức, trong lòng đã tự nhiên đã hiểu rõ sự tình của hảo bằng hữu, chỉ thở dài: \n" +
            "\n" +
            "– Vương gia, tại hạ đã nói rồi. Vũ nhi tại đan điền thập phần quái dị, hiện tại tu luyện nội công căn bản không có một tia hi vọng. Đã không thể tích tụ nội lực thì tự nhiên cũng không thể tu luyện nội công. Đan điền căn bản là do thiên sinh, trong hàng vạn người cũng không thể tìm được một người thứ hai nào như vậy, Phong Ngọc Tử ta thật sự không thể tìm ra giải pháp.\n" +
            "\n" +
            "Nghe lời đó, Tần Đức từ từ ngồi xuống trầm tư hồi lâu.\n" +
            "\n" +
            "Phụ vương, nội lực là gì, đan điền không thể tích tụ nội lực là gì? Những vị lão sư lúc nãy cũng nói đến việc này, điều đó có nghĩa gì?\n" +
            "\n" +
            "– Hài tử sáu tuổi Tần Vũ hai mắt nghi hoặc hỏi phụ thân. Lúc trước nó đã hỏi nhưng không được trả lời.\n" +
            "\n" +
            "– Tần Đức trong lòng chỉ biết cười khổ, ngoài miệng nhẹ nhàng nói:\n" +
            "\n" +
            "Vũ nhi, con hỏi nhiều như vậy làm gì, chẳng phải con đang rất vui sao? Không phải học nữa, con có thích trở về Vân Vụ sơn trang không?Tần Vũ nhất thời mắt sáng lên như ngọc trong đêm, phấn chấn nói: \n" +
            "\n" +
            "A, con không phải học những quyển sách khô khan đó nữa sao? Về Vân Vụ sơn trang con thích ôn tuyền (suối nước nóng) ở đó, con còn thích ngắm sao, ngắm cảnh mặt trời mọc.\n" +
            "\n" +
            "- Tần Đức cười đáp:\n" +
            "\n" +
            "Tốt, tốt lắm Vũ nhi, con thích là tốt rồi, cha sẽ cho người đưa con về Vân Vụ sơn trang. Cả nghìn tinh binh ở đó đều do con sai bảo, nếu như con muốn gì thì có thể trực tiếp nói với Liên gia gia\n" +
            "\n" +
            "Vâng, tuyệt quá, oa, Vân Vụ sơn trang là của con rồi, con có thể ngâm mình trong suối nước nóng cả ngày, sẽ tuyệt lắm đây.\n" +
            "\n" +
            "– Tần Vũ hưng phần nói, sắc mặt hồng lên.Trên mặt Tần Đức là một nụ cười hoàn toàn không phù hợp với hoàn cảnh, có điều Tần Vũ không thể phát hiện được.\n" +
            "\n" +
            "Con thích là được rồi. Vũ nhi, trước tiên con phải ngủ một giấc đã, khi nào đến Vân Vụ sơn trang thì Liên gia gia sẽ gọi con dậy.\n" +
            "\n" +
            "– Tần Đức cười nhẹ và xoa đầu Tần Vũ. \n" +
            "\n" +
            "Phụ vương tái kiến, Phong bá bá tái kiến.\n" +
            "\n" +
            "- Tần Vũ vẫy hai tay, trực tiếp chạy thẳng về phòng mình.Tần Đức nhìn Tần Vũ vào phòng rồi, sắc mặt bỗng trở nên nghiêm nghị rồi chuyển thân, hóa thành một đạo bóng mờ rồi biến mất trong hậu viện. Phong Ngọc Tử tựa như đã quen nên không hề tỏ ra ngạc nhiên.\n" +
            "\n" +
            "– Trong mật thất của vương phủ có ba người là Tần Đức, Phong Ngọc Tử và một hắc y thư sinh tay cầm chiết phiến.\n" +
            "\n" +
            "Vương gia, người thực sự đã quyết định rồi chứ?\n" +
            "\n" +
            "– Hắc y thư sinh nhìn Tần Đức nghi hoặc hỏi. Tần Đức gật đầu đáp:\n" +
            "\n" +
            "Vũ nhi không thể trở thành người lãnh đạo, và cũng không thể trở thành cao thủ cấp tiên thiên, nó lại không hứng thú lĩnh hội tốt những gì được dậy dỗ. Đan điền quái dị của nó, ài, điều ta có thể làm cho nó có lẽ chỉ là cuộc sống khoảng mười năm vui vẻ yên bình, đợi chúng ta bắt đầu đầu kế hoạch cuối cùng, Vũ nhi nó sẽ không thể có những ngày yên ổn.\n" +
            "\n" +
            "– Phong Ngọc Tử suy nghĩ hồi lâu rồi quyết định nói.\n" +
            "\n" +
            "Vương gia, kế hoạch này thực sự phải thực hiện sao, người phải biết rằng khi chúng ta thực hiện kế hoạch sẽ không thể biết được kết quả sẽ ra sao?\n" +
            "\n" +
            "Ảnh minh họa.','https://i.pinimg.com/originals/e4/b2/84/e4b2844509f1d266f3aa6c56fdeb05e7.jpg',1)";
    private String SQLQuery7 = "INSERT INTO truyen VALUES (null,'Phong Ngọc Tử hỏi lại một lần nữa','Tần Đức thần sắc tức thời nghiêm túc, trong mắt hàn quang chớp động.\n" +
            "\n" +
            "Ta không quản. Bất kể là vì tổ tiên Tần gia chúng ta hay là vì Tĩnh Di, kế hoạch này vẫn nhất định phải được thực hiện. Tĩnh Di lưu lại cho ta ba nhi tử, tuy nhiên Vũ nhi đan điền có vấn đề. Nhưng Phong nhi và Chính nhi một văn một võ, khả dĩ có thể thành đại sự. Từ Nguyên, đệ nhất ám kì đã bắt đầu triển khai chưa?\n" +
            "\n" +
            "- Hắc y thư sinh Từ Nguyên hạ phe phẩy quạt nói: \n" +
            "\n" +
            "Vương gia yên tâm, mọi việc nhất thiết đều trong tầm kiểm soát.\n" +
            "\n" +
            "Tốt, rất tốt.\n" +
            "\n" +
            "- Tần Đức trong mắt phát xuất một tia sát khí kinh nhân. Trấn Đông vương Tần Đức ở tại Tiềm Long đại lục.\n" +
            "\n" +
            "– Tiềm Long đại lục diện tích rất lớn, cho đến giờ vẫn chưa ai có thể hiểu hết được. Phía đông của Tiềm Long đại lục là Hồng Hoang Vô Biên, trong vùng hồng hoang là núi non trùng điệp, cây cối dầy đặc, trong đó có vô số yêu thú.\n" +
            "\n" +
            "- Càng đi sâu vào trong thì yêu thú càng lợi hại, đó là nguyên nhân khiến thượng tiên trên Tiềm Long đại lục không thể thăm dò toàn bộ vùng Hồng Hoang Vô Biên. Phía tây của Hồng Hoang Vô Biên có ba quốc gia lớn. Sở vương triều, Minh vương triều, Hán vương triều ba đại vương triều nhân khẩu tổng cộng gần trăm ức (1 ức=100,000), diện tích rộng lớn khiến người ta phải kinh hãi. Trong ba vương triều thì Sở vương triều là cường đại nhất, trong Sở vương triều có một gia tộc tách riêng độc lập là Tần gia. Tần gia chiếm cứ ba quận đông vực trong mười hai quận của Sở vương triều. Tại ba quận đông vực gần Hồng Hoang Vô Biên. Tần gia truyền qua hơn trăm năm tại ba quận đông vực căn cơ vô cùng thâm hậu, cho dù là hoàng đế của Sở vương triều đích thân đối phó thì cũng thập phần gian nan bởi vì Tần gia có một binh chủng đặc thù là Liệt Hổ quân.\n" +
            "\n" +
            "- Liệt hổ toàn thân xích hồng, thân hình to lớn, chính thị lão hổ. Phương pháp nuôi dưỡng liệt hổ trên quy mô lớn chính là điều cơ mật trọng yếu hạng nhất của Tần gia.\n" +
            "\n" +
            "- Tần gia nắm trong tay sáu mươi vạn đại quân, trong đó có năm vạn Liệt Hổ quân, mỗi chiến sĩ trong Liệt Hổ quân đều cưỡi liệt hổ khi ra trận. Liệt hổ có lực công kích kinh thế hãi nhân, thêm vào chiến sĩ phía trên phối hợp có thể quét sạch mọi chướng ngại vật.\n" +
            "\n" +
            "– Duy chỉ năm vạn liệt hổ là có thể sử dụng hổ hống, khả nă ng này có thể triệt hạ hoàn toàn sĩ khí quân địch. Năm vạn liệt hổ quân có thể tiêu diệt hơn mười vạn đại quân kị binh phổ thông.Tiềm Long đại lục vũ lực cực cao, ba quốc gia lớn đều có các tu tiên giả trấn quốc.\n" +
            "\n" +
            "- Mỗi tu tiên giả tồn tại trong mắt phàm nhân đều tựa như thần tiên. Phi kiếm xuất ra có thể lấy đầu người ngoài trăm ngàn dặm, ngự kiếm phi hành bay lên đến tận chín tầng trời, chẳng phải là khả năng của thần tiên sao?\n" +
            "\n" +
            "- Vân Vụ sơn trang ngự tại Đông Lam sơn. Đông Lam sơn cao hơn ba nghìn thước, là một ngọn núi rất cao.\n" +
            "\n" +
            "\n" +
            "Ảnh minh họa','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQmyHeXhTNg-BXCk5EoNleflLhxmSlhKy1K9w&usqp=CAU',1)";
    private String SQLQuery8 = "INSERT INTO truyen VALUES (null,'Hai năm sau','Lúc này Tần Vũ đã tám tuổi và cũng cao lên nhiều, trong mắt hiện lên vẻ trí tuệ tuy nhiên sâu trong đó lại ẩn chứa chút u buồn. Tần Vũ đang một mình đi trên sơn đạo, trên vai là một con ưng đen.\n" +
            "\n" +
            "\n" +
            "Tiểu Hắc, đã qua hai năm rồi nhỉ, suốt hai năm phụ vương chỉ ghé qua thăm ta đúng một lần. Tần Vũ cắn hai môi, quay sang hắc ưng nói.\n" +
            "- Con ưng nhỏ này một năm trước Tần Vũ du lãm Đông Lam sơn đã phát hiện ra, tiện thể bên thân có ưng đái nên kết bạn với nó. Tần Vũ thực sự rất cô độc. Sáu tuổi trở về trước còn có phụ thân bầu bạn, hai năm gần đây kể từ khi sáu tuổi chỉ nhìn thấy phụ thân đúng một lần.\n" +
            "– Hắc ưng vỗ cánh, lông vũ bay vào mặt Tần Vũ khiến nó nhất thời nở một nụ cười.\n" +
            "– Đi được một đoạn Tần Vũ đột nhiên nhìn thấy phía trước có một dựng phụ (phụ nữ có mang) gánh một gánh củi đang khó khăn đi tới, liền quay sang hắc ưng nói:\n" +
            "Tiểu Hắc, chúng ta tới giúp a di kia nhé?\n" +
            "– Hắc ưng tức thì vỗ cánh, rời khỏi vai Tần Vũ. Tần Vũ nhanh chóng chạy về phía dựng phụ nọ.\n" +
            "A di, a di để cháu gánh củi giúp cho.\n" +
            "- Tần Vũ hướng về phía phụ nhân nọ nói.Phụ nhân nghe thấy thanh âm bèn nhìn lại bó củi trên vai, đưa tay áo lên lau mồ hồi rồi nhìn sang tiểu hài đồng Tần Vũ, cười nói: \n" +
            "Tiểu oa nhi, cảm ơn cháu, ai di có thể mang được, chỉ còn một dặm nữa là đến tiểu thôn rồi nói rồi xốc lại bó củi trên vai rồi tiếp tục đi tới.\n" +
            "Tiểu oa nhi? Cháu không còn nhỏ nữa, cháu đã tám tuổi rồi, bó củi đó cháu có thể mang được.\n" +
            "– Tần Vũ nhìn sang dựng phụ, đột nhiên giành lầy bó củi rồi vác lên vai.\n" +
            "– Bó củi đối với người bình thường thì không nặng lắm, nhưng với một hài tử mới tám tuổi thì đúng là rất nặng. Chỉ là Tần Vũ tại Vân Vụ sơn trang thường ngâm mình trong suối nước nóng nên thân thể cường tráng không giống như những đứa trẻ tám tuổi khác, ngang nhiên vác bó củi trên vai.\n" +
            "A di nhìn xem, cháu có thể mang được đúng không? Hà, a di không được gọi cháu là tiểu oa nhi nữa nhé.\n" +
            "– Tần Vũ đắc ý nói, không kể trên mặt mình có dính một vết nhọ.Phụ nhân nọ cười nói: \n" +
            "Khí lực quả không nhỏ, bất quá còn một dặm nữa, oa nhi cháu sẽ không chịu được đâu, thôi nhường lại để a di còn đi tiếp.\n" +
            "Ai nói cháu không thể chịu đến cùng.\n" +
            "– Tần Vũ nhìn dựng phụ, hất tay một cái rồi nhanh chóng tiến về phía trước. Đang đi bỗng nhiên quay đầu lại nói: \n" +
            "Adi, cháu đã lên Đông Lam sơn nhiều lần rồi, được biết là ngoài một tiểu thôn trang ra thì không có nơi nào khác, chắc chắn là nơi đó đúng không. Nhanh lên, nhanh lên nào, a di đừng để cháu phải chờ đó!\n" +
            "\n" +
            "\n" +
            "Ảnh minh họa.','https://hemtruyenma.info/upload/pro/Hau-Tinh-Than-Bien.jpg?quality=100&mode=crop&anchor=topleft&width=450&height=675',1)";

    //tao bang tai phuong thuc nay
    public databasedoctruyen(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //thực hiện các câu lệnh truy vấn không trả về kết quả
        db.execSQL(SQLQuery);
        db.execSQL(SQLQuery1);
        db.execSQL(SQLQuery2);
        db.execSQL(SQLQuery3);
        db.execSQL(SQLQuery4);
        db.execSQL(SQLQuery5);
        db.execSQL(SQLQuery6);
        db.execSQL(SQLQuery7);
        db.execSQL(SQLQuery8);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    //phương thức lấy tất cả các tài khoản
    public Cursor getData(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " +TABLE_TAIKHOAN, null);
        return res;
    }
    //phương thức add tài khoản vào database
    public void AddTaiKhoan(TaiKhoan taiKhoan){
        SQLiteDatabase db = this.getWritableDatabase();
        //thực hiện ínert thông tin qua Contenvalues
        ContentValues values = new ContentValues();
        values.put(TEN_TAI_KHOAN,taiKhoan.getnNameAcc());
        values.put(MAT_KHAU,taiKhoan.getnPass());
        values.put(EMAIL,taiKhoan.getnMail());
        values.put(PHAN_QUYEN,taiKhoan.getnPhanQuyen());
        db.insert(TABLE_TAIKHOAN,null,values);
        //đóng lại khi không đúng
        db.close();
        Log.e("ADD ACCOUNT","SUCCESS");
    }
    //lấy 4 truyện tức mới nhất
    public Cursor getData1(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_TRUYEN+" ORDER BY "+ID_TRUYEN+" DESC LIMIT 5 ",null);
        return res;
    }
    //lấy tất cả truyện
    public Cursor getData2(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_TRUYEN,null);
        return res;
    }
    //Add truyện
    public void AddTruyen(AppTruyen truyen){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TEN_TRUYEN,truyen.getNameTruyen());
        values.put(NOI_DUNG,truyen.getNoiDung());
        values.put(IMAGE,truyen.getImage());
        values.put(ID_TAI_KHOAN,truyen.getID_ACC());
        db.insert(TABLE_TRUYEN,null,values);
        db.close();
    }
    //delete truyện
    public int Delete(int i){
        SQLiteDatabase db = this.getReadableDatabase();
        int res = db.delete(TABLE_TRUYEN,ID_TRUYEN+" = "+i,null);
        return res;
    }
}
