package HW2;
import java.io.*;
import java.util.*;
public class Main {
	public static String[] sort(String[]s,int n) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n-i-1;j++) {
				if(s[j].compareToIgnoreCase(s[j+1])>0) {
					String temp=s[j];
					s[j]=s[j+1];
					s[j+1]=temp;
				}
			}
		}
		return s;
	}
	public static int search(String[]s,String d,int n) {
		int i=0,j=n-1,m,f=0;
		while(i<=j)
		{
			m=(i+j)/2;
			if(d.compareToIgnoreCase(s[m])==0) {
				f=1;break;
			}
			else if(d.compareToIgnoreCase(s[m])>0) {
				i=m+1;
			}
			else
				j=m-1;
		}
		return f;
	}
    public static void main(String[]args)throws FileNotFoundException
    {
    	String[] key=new String[84];
    	String[] dict=new String[16000];
    	File dicti=new File("E:\\KishoreJava\\files\\HW2-dictionary.txt");
    	File keyw=new File("E:\\KishoreJava\\\\files\\HW2-keywords.txt");
    	try{FileWriter output=new FileWriter("E:\\KishoreJava\\\\files\\HW2-output.txt",true);
    	Scanner d=new Scanner(dicti);
    	Scanner k=new Scanner(keyw);
    	int i=0,j=0,count=0,count1=0;
    	while(k.hasNextLine())
    	{
    		key[i]=k.nextLine();
    		i++;
    	}
    	while(d.hasNextLine())
    	{
    		dict[j]=d.nextLine();
    		j++;
    	}
    	key=sort(key,84);
    	dict=sort(dict,16000);
    	for(j=0;j<84;j++) {
    		int h=search(dict,key[j],16000);
    		if(h==0) {
    			{
    			 String g=new String("Keyword not found: "+key[j]);
    			 count++;
    			 output.write(g);
    			 output.write(System.getProperty( "line.separator" ));
    			}
    		
    		}
    		if(h==1) {
				count1++;
			}
    	}
    	output.write("No. of Keywords not found is "+count);
    	output.write(System.getProperty( "line.separator" ));
    	output.write("No. of Keywords found is "+count1);
    	d.close();
    	k.close();
		output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
