
public class ParaStyle {
    private String name;
    private int leftIndent;
    private int lineLength;
    private int firstLineAdjustment;

    public ParaStyle(String name, int leftIndent, int lineLength, int firstLineAdjustment){
        setName(name);
        setLeftIndent(leftIndent);
        setLineLength(lineLength);
        setFirstLineAdjustment(firstLineAdjustment);
    }
     
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
     
    public int getLeftIndent(){
        return leftIndent;
    }
    
    public void setLeftIndent(int leftIndent){
    	if (leftIndent >= 0 && leftIndent <= 15)
    		this.leftIndent = leftIndent;
    }
     
    public int getLineLength(){
        return lineLength;
    }
    
    public void setLineLength(int lineLength){
    	if (lineLength >= 30)
        	this.lineLength = lineLength;
    }
     
    public int getFirstLineAdjustment(){
        return firstLineAdjustment;
    }
    
    public void setFirstLineAdjustment(int firstLineAdjustment){
    	if (this.leftIndent + firstLineAdjustment >= 0)
    		this.firstLineAdjustment = firstLineAdjustment;
    }
    
    public String toString(){
        return String.format("% % % %", name, leftIndent, lineLength, firstLineAdjustment);
    }
}
