package controleestoqueuam;

import java.io.IOException;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;

/**
 *
 * Rubens Guarnieri, R.A.: 20303016
 * Erik Henrique, R.A.: 20301986
 */
public class AppLivraria {
    public static void main(String[] args) throws IOException, BiffException, WriteException {
        jExcel excel;
        excel = new jExcel();
        
        AppLivrariaController iniciar = new AppLivrariaController();
        
    }
}
