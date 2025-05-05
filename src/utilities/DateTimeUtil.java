package utilities;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DateTimeUtil {
	public static boolean isDate(String date, JFrame frame)
	{
		String[] dateComp = date.split("-");
		int year;
		byte month, day;
		try {
			year = Integer.valueOf(dateComp[0]);
			month = Byte.valueOf(dateComp[1]);
			day = Byte.valueOf(dateComp[2]);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(frame, "Định dạng ngày tháng không hợp lệ, phải là yyyy-MM-dd", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		if(!(year >= 1800 && year < 10000))
		{
			JOptionPane.showMessageDialog(frame, "Năm phải lớn hơn 1000 và chỉ được có 4 chữ số", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		if(!(month >= 1 && month <= 12))
		{
			JOptionPane.showMessageDialog(frame, "Tháng chỉ có từ 1 - 12", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		if(!(day >= 1 && day <= 31))
		{
			JOptionPane.showMessageDialog(frame, "Số ngày chỉ được từ 1 - 31", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		switch (month) {
		case 4: case 6: case 9: case 11: {
			if(day > 30)
			{
				JOptionPane.showMessageDialog(frame, "Tháng " + month + " chỉ có 30 ngày", "Thông báo", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			break;
		}
		
		case 2:
			if(isNamNhuan(year) && day > 29)
			{
				JOptionPane.showMessageDialog(frame, "Tháng " + month + " năm " + year + "chỉ có 29 ngày", "Thông báo", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			else if(!isNamNhuan(year) && day > 28)
			{
				JOptionPane.showMessageDialog(frame, "Tháng " + month + " năm " + year + "chỉ có 28 ngày", "Thông báo", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			break;
		default:
			
		}
		
		return true;
	}
    
    private static boolean isNamNhuan(int year)
    {
    	if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
            return true;
        return false;
    }

	public static boolean isTime(String time, JFrame frame)
	{
		String[] parts = time.split(":");
		byte hour;
		byte minute;
		byte second;
		try {
			hour = Byte.valueOf(parts[0]);
			minute = Byte.valueOf(parts[1]);
			second = Byte.valueOf(parts[2]);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frame, "Định dạng thời gian không hợp lệ. Phải là hh:mm:ss", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if(!(hour >= 0 && hour <= 23))
		{
			JOptionPane.showMessageDialog(frame, "Số giờ không hợp lệ. 1 ngày chỉ có từ 00 - 23 giờ", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		else if(!(minute >= 0 && minute <= 59))
		{
			JOptionPane.showMessageDialog(frame, "Số phút không hợp lệ. 1 giờ chỉ có từ 00 - 59 phút", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		else if(!(second >= 0 && second <= 59))
		{
			JOptionPane.showMessageDialog(frame, "Số giây không hợp lệ. 1 phút chỉ có từ 00 - 59 phút", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		return true;
	}

	public static String getDate(String DateTime)
	{
		String[] parts = DateTime.split(" ");
		return parts[0];
	}

	public static String getTime(String DateTime)
	{
		String[] parts = DateTime.split(" ");
		return parts[1];
	}
}
