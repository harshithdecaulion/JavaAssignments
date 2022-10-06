package com.valtech.training.corejava.day3;

import java.io.IOException;
import java.io.Writer;

public class Rot13Writer extends Writer {
	private Writer sink;
	
	public Rot13Writer (Writer sink) {
		this.sink=sink;
		
	}
	@Override
	
	public void write (char[] cbuf,int off,int len) throws IOException{
	char[] buffer= new char [cbuf.length];
	for (int j = 0; j < buffer.length; j++) {
		buffer [j]=Rot13Utility.rotate(cbuf[j]);
	}
	sink.write(cbuf, off, len);
	}
	@Override 
	public void flush() throws IOException{
	sink.flush();
}
	@Override
	public void close () throws IOException{
		sink.close();
}
}