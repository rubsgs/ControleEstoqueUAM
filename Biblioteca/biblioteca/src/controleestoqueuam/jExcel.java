package controleestoqueuam;

import java.io.File;
import java.io.IOException;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;


/**
 *
 * @author Erik Henrique
 */
public class jExcel {
    
    public jExcel() throws IOException, WriteException {
        
        WritableWorkbook workbook; 
        workbook = Workbook.createWorkbook(new File("C:/Users/Erik Henrique/Biblioteca.xls"));
        
        WritableSheet sheet = workbook.createSheet("Livros", 0);
        
        Label texto;
        sheet.addCell(new Label(0, 0, "Livros"));
        sheet.addCell(new Label(0, 1, "Nome"));
        sheet.addCell(new Label(1, 1, "Código"));
        sheet.addCell(new Label(2, 2, "Preço"));
        
        workbook.write(); 
        workbook.close();
    }
    
}
