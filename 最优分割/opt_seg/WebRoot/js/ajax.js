function getWorkBook(){   
   
var excelPath=document.getElementById("excelPath").value; 
excelPath=encodeURI(excelPath)
excelPath=encodeURI(excelPath)
$.ajax({
 		type: "POST",    
        url: "GetExcelWorkBook",    
        data: "excelPath="+excelPath, 
        success: function(data){  
       		document.getElementById("test").innerHTML=data; 
 		 }          
});   

} 