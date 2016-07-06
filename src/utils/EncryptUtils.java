package utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


public class EncryptUtils {
   public static final String DEFAULT_ENCODING="UTF-8"; 
   static BASE64Encoder enc=new BASE64Encoder();
   static BASE64Decoder dec=new BASE64Decoder();

   public static String base64encode(String text){
      try {
         String rez = enc.encode( text.getBytes( DEFAULT_ENCODING ) );
         return rez;         
      }
      catch ( UnsupportedEncodingException e ) {
         return null;
      }
   }//base64encode

   public static String base64decode(String text){

         try {
            return new String(dec.decodeBuffer( text ),DEFAULT_ENCODING);
         }
         catch ( IOException e ) {
           return null;
         }

      }//base64decode

   //X19ZUk0KCQVOGABEGAAWBERRS1BbEgNARFFXWw
   //X19ZU00KCQVOGABEGAAWBERRS1BbEgNARFFXWw
   //X19ZVU0KCQVOGABEGAAWBERRS1BbEgNARFFXWw
   //X19ZVE0KCQVOGABEGAAWBERRS1BbEgNARFFXWw
   //X19ZVF9dUFEAEQlBDA8TBR4AFgROEQtDQFteXl1YGFM
   //X19ZVV9dUFAAEQlBDA8TBR4AFgROEQtDQFteXl1YGFM
   //X19ZVU0KCQVOGABEGAAWBERTQlBaAQJLRF1cXV5QGVxSU1tXX1E
   //X19ZVE0KCQVOGABEGAAWBERTQlBbAQJLRF1cXV5QGVxSU1tXX1A\
   
   //X19ZVE0KCQVOGABEGAAWBERVQlJeAQJLRF1cXV5QGVxSU19XWlA
   
   //X19ZVE0KCQVOGABEGAAWBERVQlJeAQJLRF1cXV5QGVxSU19XWlA
   //X19ZVU0KCQVOGABEGAAWBERVQlNWAQJLRF1cXV5QGVxSU19XWlc
   
   //X19ZVU0KCQVOGABEGAAWBERVQlNWAQJLRF1cXV5QGVxSU19XWlc
   //X19ZVE0KCQVOGABEGAAWBERVQlJeAQJLRF1cXV5QGVxSU19XWlA
   //X19ZUU0KCQVOGABEGAAWBERVQlNeAQJLRF1cXV5QGVxSU19XXVU
   
   
      public static void main(String[] args){
    	  String txt="201 ghannadzade 4020 09153121987 6030" ;
    	  //first part is in c:\\ebuhcnurhuwbfxanhdw
    	  //third is in sum of year :)*3
          String key="mohammad va baradaran!2"+"ruholla designer"+"333";
          System.out.println(txt+" XOR-ed to: "+(txt=xorMessage( txt, key )));
          String encoded=base64encode( txt );       
          System.out.println( " is encoded to: "+encoded+" and that is decoding to: "+ (txt=base64decode( encoded )));
          System.out.print( "XOR-ing back to original: "+xorMessage( txt, key ) );

      }
      static void originalTest(){
    	  String txt="some text to be encrypted" ;
          String key="key phrase used for XOR-ing";
          System.out.println(txt+" XOR-ed to: "+(txt=xorMessage( txt, key )));
          String encoded=base64encode( txt );       
          System.out.println( " is encoded to: "+encoded+" and that is decoding to: "+ (txt=base64decode( encoded )));
          System.out.print( "XOR-ing back to original: "+xorMessage( txt, key ) );

      }

      public static String xorMessage(String message, String key){
       try {
          if (message==null || key==null ) return null;

         char[] keys=key.toCharArray();
         char[] mesg=message.toCharArray();

         int ml=mesg.length;
         int kl=keys.length;
         char[] newmsg=new char[ml];

         for (int i=0; i<ml; i++){
            newmsg[i]=(char)(mesg[i]^keys[i%kl]);
         }//for i
         mesg=null; keys=null;
         return new String(newmsg);
      }
      catch ( Exception e ) {
         return null;
       }  
      }//xorMessage

}//class