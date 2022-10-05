import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {

	
	
	public void Read() {
		
		try {
		    
			File file = new File ("ship3.xls");
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(file));
		    HSSFWorkbook wb = new HSSFWorkbook(fs);
		   
		    
		    HSSFSheet sheet = wb.getSheetAt(0);
		    HSSFRow row;
		    HSSFCell cell;

		    int rows; // No of rows
		    rows = sheet.getPhysicalNumberOfRows();

		    int cols = 0; // No of columns
		    int tmp = 0;

		    // This trick ensures that we get the data properly even if it doesn't start from first few rows
		    for(int i = 0; i < 10 || i < rows; i++) {
		        row = sheet.getRow(i);
		        if(row != null) {
		            tmp = sheet.getRow(i).getPhysicalNumberOfCells();
		            if(tmp > cols) cols = tmp;
		        }
		    }

		    for(int r = 0; r < rows; r++) {
		        row = sheet.getRow(r);
		        if(row != null) {
		            for(int c = 0; c < cols; c++) {
		                cell = row.getCell((short)c);
		                if(cell != null) {
		                    // Your code here
		                }
		            }
		        }
		    }
		} catch(Exception ioe) {
		    ioe.printStackTrace();
		}
	}
	
	
	 public int[][][] ReadXLSX() throws IOException {
	        
		 
		 int imageMap [][][] = new int[11][11][5]; 
		 File file = new File ("ship01.xls");
		 FileInputStream files;
		 Workbook workbook;
	
			files = new FileInputStream(file);
		 
		 //try (XSSFWorkbook wb = new XSSFWorkbook()) {
		 workbook = new XSSFWorkbook(files);
	        	Sheet sheet = workbook.getSheetAt(0);
	        	   final int NUM_OF_ROWS = 11;
		            final int NUM_OF_COLUMNS = 11;
		            final int NUM_OF_DEPTH = 5; 
	        	
		            int j=0; 
		            for (Row row : sheet) {
		        	    
		            	j++;
		        	   for (int k=0;k<NUM_OF_COLUMNS;k++) 
		        	   {
		        		  Cell cell = row.getCell(k); 
		        		  if (cell!=null)
		        		  {
		        			  imageMap[j][k][0] = (int) cell.getNumericCellValue();
		        			  //System.out.println("x: "+j +" y : "+k+ " z: 0"+" cell: "+imageMap[j][k][0]);
		        		  }
		        	   }
		            }
		            
		            return imageMap;
	        	/*Map<Integer, List<String>> data = new HashMap<>();
	        	int i = 0;
	        	for (Row row : sheet) {
	        	    data.put(i, new ArrayList<String>());
	        	    for (Cell cell : row) {
	        	        switch (cell.getCellTypeEnum()) {
	        	            case STRING: ... break;
	        	            case NUMERIC: ... break;
	        	            case BOOLEAN: ... break;
	        	            case FORMULA: ... break;
	        	            default: data.get(new Integer(i)).add(" ");
	        	        }
	        	    }
	        	    i++;
	        	}*/
	        	
	        	/*XSSFSheet sheet = wb.createSheet("Sheet 1");
	     

	            // Create a row and put some cells in it. Rows are 0 based.
	            Row row;
	            Cell cell;
	            for (int rowIndex = 0; rowIndex < NUM_OF_ROWS; rowIndex++) {
	                row = sheet.createRow((short) rowIndex);
	                for (int colIndex = 0; colIndex < NUM_OF_COLUMNS; colIndex++) {
	                    cell = row.createCell((short) colIndex);
	                    cell.setCellValue(colIndex * (rowIndex + 1));
	                }
	            }
	        */
	          /*  XSSFDrawing drawing = sheet.createDrawingPatriarch();
	            XSSFClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 0, 5, 10, 15);
	    
	            XSSFChart chart = drawing.createChart(anchor);
	            XDDFChartLegend legend = chart.getOrAddLegend();
	            legend.setPosition(LegendPosition.TOP_RIGHT);
	    
	            XDDFValueAxis bottomAxis = chart.createValueAxis(AxisPosition.BOTTOM);
	            XDDFValueAxis leftAxis = chart.createValueAxis(AxisPosition.LEFT);
	            leftAxis.setCrosses(AxisCrosses.AUTO_ZERO);
	    
	            XDDFDataSource<Double> xs = XDDFDataSourcesFactory.fromNumericCellRange(sheet, new CellRangeAddress(0, 0, 0, NUM_OF_COLUMNS - 1));
	            XDDFNumericalDataSource<Double> ys1 = XDDFDataSourcesFactory.fromNumericCellRange(sheet, new CellRangeAddress(1, 1, 0, NUM_OF_COLUMNS - 1));
	            XDDFNumericalDataSource<Double> ys2 = XDDFDataSourcesFactory.fromNumericCellRange(sheet, new CellRangeAddress(2, 2, 0, NUM_OF_COLUMNS - 1));
	    
	    
	            XDDFChartData data = chart.createData(ChartTypes.SCATTER, bottomAxis, leftAxis);
	    
	            data.addSeries(xs, ys1);
	            data.addSeries(xs, ys2);
	            chart.plot(data);

	            // Write the output to a file
	            try (FileOutputStream fileOut = new FileOutputStream("ooxml-scatter-chart.xlsx")) {
	                wb.write(fileOut);
	            }
	            */
	        //}
	    }
public ShipStructure ReadShip() {
		
	ShipStructure ship = new ShipStructure();
		
	int imageMap [][][] = new int[100][100][50]; 
	try {
		    
			//File file = new File ("ship03.xls");
		   //File file = new File ("tf2000.xls");
		// File file = new File ("bodrumdot.xls");
		//File file = new File ("minipixelart2.xls");
		File file = new File ("cripper2.xls");
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(file));
		    HSSFWorkbook wb = new HSSFWorkbook(fs);
		    
		   //https://imagecolorpicker.com/
		    //int colCount = 11; 
		    int depthCount=wb.getNumberOfSheets();
		    System.out.println("Number of sheets : " +depthCount);
		    int r=0;
	    	int c=0; 
	    	int maxLength = 0; 
	    	int maxHeight = 0; 
		    for (int k=0;k<depthCount;k++) 
		    {
		       
		    
		    	HSSFSheet sheet = wb.getSheet("S"+(k+1)+"");
		    	HSSFRow row;
		    	HSSFCell cell;
		    	
		    	System.out.println("k: "+k + " SheetName: "+sheet.getSheetName());
		   // 	rows = rowCount; // sheet.getPhysicalNumberOfRows();

		    //	int cols = colCount; //0; // No of columns


		    // 	This trick ensures that we get the data properly even if it doesn't start from first few rows
		    	/*for(int i = 0; i < 10 || i < rows; i++) {
		    		row = sheet.getRow(i);
		    		if(row != null) {
		    			tmp = sheet.getRow(i).getPhysicalNumberOfCells();
		                if(tmp > cols) 
		            	 cols = tmp;
		    		}
		    	}*/

		    	//for(int r = 0; r < rows; r++) {
		    	
		    	boolean rowsFlag = true; 
		    	boolean cellsFlag = true;
		    	r=0;

		    	while (rowsFlag) 
		    	{
		    		row = sheet.getRow(r);
		    		rowsFlag = row != null;
		    		if(rowsFlag) {
		    			
		    			 cellsFlag = true;
		    			 c=0;
		    			while (cellsFlag)
		    			{
		    				cell = row.getCell((short)c);
		    				cellsFlag = cell != null;
		    				if(cellsFlag) {
		    					imageMap[c][r][k] = (int) cell.getNumericCellValue(); 
		    					System.out.println("x: "+c +" y : "+r+ " z: "+k+" cell: "+imageMap[c][r][k]);
		    					c++;
		    					if (c>maxLength)
		    						maxLength = c; 
		    				}
		    			}
		    		}
		    		r++;
		    		if (r>maxHeight)
		    			maxHeight = r; 
		    	}
		    	
		    	
		    }//k
		    
		    ship.width = depthCount;
		    ship.length = maxLength; 
		    ship.height = maxHeight; 
		    ship.data=new int [ship.length][ship.height][ship.width] ; 
		    
		    
		    for (int i=0; i<ship.length; i++) 
		    {
		    	for (int j=0;j<ship.height;j++)
		    	{
		    		for (int k=0;k<ship.width;k++) 
		    		{
		    			ship.data[i][j][k] = imageMap[i][j][k]; 
		    		}
		    	}
		    		
		    }
		    
		} catch(Exception ioe) {
		    ioe.printStackTrace();
		}
		
	
	return ship; 
	}
	
/*	public void Write () 
	{
		//Blank workbook
	    XSSFWorkbook workbook = new XSSFWorkbook();

	    //Create a blank sheet
	    XSSFSheet sheet = workbook.createSheet("Employee Data");

	    //This data needs to be written (Object[])
	    Map<String, Object[]> data = new TreeMap<String, Object[]>();
	    data.put("1", new Object[]{"ID", "NAME", "LASTNAME"});
	    data.put("2", new Object[]{1, "Amit", "Shukla"});
	    data.put("3", new Object[]{2, "Lokesh", "Gupta"});
	    data.put("4", new Object[]{3, "John", "Adwards"});
	    data.put("5", new Object[]{4, "Brian", "Schultz"});

	    //Iterate over data and write to sheet
	    Set<String> keyset = data.keySet();

	    int rownum = 0;
	    for (String key : keyset) 
	    {
	        //create a row of excelsheet
	        Row row = sheet.createRow(rownum++);

	        //get object array of prerticuler key
	        Object[] objArr = data.get(key);

	        int cellnum = 0;

	        for (Object obj : objArr) 
	        {
	            Cell cell = row.createCell(cellnum++);
	            if (obj instanceof String) 
	            {
	                cell.setCellValue((String) obj);
	            }
	            else if (obj instanceof Integer) 
	            {
	                cell.setCellValue((Integer) obj);
	            }
	        }
	    }
	    try 
	    {
	        //Write the workbook in file system
	        FileOutputStream out = new FileOutputStream(new File("C:\\Documents and Settings\\admin\\Desktop\\imp data\\howtodoinjava_demo.xlsx"));
	        workbook.write(out);
	        out.close();
	        System.out.println("howtodoinjava_demo.xlsx written successfully on disk.");
	    } 
	    catch (Exception e)
	    {
	        e.printStackTrace();
	    }
	}*/
	
}
