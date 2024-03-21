package chainofresponsibility;

enum FileType {
	TEXT("text"), IMAGE("image");
	
	public String type;
	
	FileType(String type) {
		this.type = type;
	}
	
	String getType() {
		return type;
	}
}

class File {			// Request
	
	private String fileName;
	private FileType fileType;
	
	public File(String fileName, FileType fileType) {
		this.fileName = fileName;
		this.fileType = fileType;
	}

	public String getFileName() {
		return fileName;
	}
	
	public String getFileType() {
		return fileType.getType();
	}
}

interface Handler {
	
	 void setHandler(Handler handler);
	 void process(File file);
	 String getHandlerName();
}

class TextFileHandler implements Handler {

	private Handler handler;
	private String handlerName;
	
	public TextFileHandler(String handlerName){
		this.handlerName = handlerName;
	}
	
	@Override
	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	@Override
	public String getHandlerName() {
		return handlerName;
	}

	@Override
	public void process(File file) 
	{	
		if(file.getFileType().equals(FileType.TEXT.type)){
			System.out.println("Handling the File => "+ file.getFileName() + " using => " + handlerName);
		}else if (handler != null) {
			System.out.println( handlerName+" fowarding the request to => "+handler.getHandlerName());
			handler.process(file);
		}else {
			System.out.println("File not Supported");
		}
	}
	
}

class ImageFileHandler implements Handler {
	
	private Handler handler;
	private String handlerName;
	
	public ImageFileHandler(String handlerName){
		this.handlerName = handlerName;
	}

	@Override
	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	@Override
	public void process(File file) 
	{
		if(file.getFileType().equals(FileType.IMAGE.type)){
			System.out.println("Handling the File => "+ file.getFileName() + " using => " + handlerName);
		}else if (handler != null) {
			System.out.println( handlerName+" fowarding the request to => "+handler.getHandlerName());
			handler.process(file);
		}else {
			System.out.println("File not Supported");
		}
	}

	@Override
	public String getHandlerName() {
		return handlerName;
	}
	
}

public class TestChainOfResponsibilityPattern {

	public static void main(String[] args) {
		
		Handler handler = new TextFileHandler("Text Handler");
		Handler imageHandler = new ImageFileHandler("Image Handler");
		
		handler.setHandler(imageHandler);
		
		File file = new File("Abc.txt", FileType.TEXT);
		handler.process(file);
		
		file = new File("Abc.img",FileType.IMAGE);
		handler.process(file);
	}

}
