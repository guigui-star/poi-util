
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author guigui
 * @create 2020-10-28 9:17
 */
public class ExeclUtil {
    public static <T> List<T> importExcel(String url, T t) throws Exception {
        //先反射，获取类
        Class<?> clazz = t.getClass();
        Map param=new HashMap();
        //获取类的属性名，属性类型类型
        Field[] fields = clazz.getDeclaredFields();
        System.out.println("属性参数方法为"+fields);
        for (int i = 0; i < fields.length; i++) {
            param.put(fields[i].getName(),fields[i].getType());
        }

        System.out.println(param);
        List<T> list=new ArrayList<T>();
        Workbook workbook= WorkbookFactory.create(new File(url));
        Sheet sheet = workbook.getSheetAt(0);
        for (int i=1;i<=sheet.getLastRowNum();i++) {//跳过第一行
            Row row = sheet.getRow(i);//取得第i行数据
            //ExeclTest test = new ExeclTest();
            String[] str = new String[row.getLastCellNum()];
            for (int j = 0; j < row.getLastCellNum(); j++) {
                Cell cell = row.getCell(j);//取得第j列数据
                cell.setCellType(CellType.STRING);
                str[j] = cell.getStringCellValue().trim();
            }
            //创建类的对象
            T instance = (T)clazz.newInstance();
            //拿到第一行的数据，作为key
            for (int k=0;k< row.getLastCellNum(); k++){
                row=sheet.getRow(0);
                Cell cell=row.getCell(k);
                cell.setCellType(CellType.STRING);//取得第一列的key
                String trim = cell.getStringCellValue().trim();
                //将第一个字符改为大写
                String trim1=trim.substring(0,1).toUpperCase()+trim.substring(1);
                //调用set 方法
                Method declaredMethod = clazz.getDeclaredMethod("set" + trim1, (Class<?>)param.get(trim));
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(instance,str[k]);
            }
            list.add(instance);
        }

        return list;
    }
    public static void main(String[] args) {
        ExeclTest execlTest=new ExeclTest();
        test1 te=new test1();
        try {
            List<test1> sdasda = importExcel("C:/Users/guigui/Desktop/test.xlsx", te);
            System.out.println(sdasda);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
