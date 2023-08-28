/*
*				Christof Peter Thomalla
*				martikelnummer 11152240
*
*				This AES Encryption uses GCM WITH keyLength of 192 bit and NoPadding
*
*               myhexkey tested with 277586834785493572857883277586834785493572857883
*/




import java.io.*;
import java.util.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import javax.swing.undo.UndoableEditSupport;



public class EncryptionAES {

    private int keyLength = 192;
    private String operationMode = "GCM";

    public int getKey() {
        return keyLength;
    }

    public static void main(String[] args) throws InvalidAlgorithmParameterException, NoSuchAlgorithmException,
            NoSuchPaddingException, IOException, InvalidKeyException {

        String inputFilename = null, myhexkey = null; // myhexkey is just a key our chosing to encrypt or decrypt the
                                                      // data
        // (THE HEX CONVERSION WILL BE DONE IN CODE)
        boolean dec = false, stat = false;
        String outputFilename;
        EncryptionAES AE = new EncryptionAES();

        // checking for argunents in comandline (filename,key,dec)
        for (int i = 0; i < args.length; i++) {
            if ("-filename".equals(args[i])) // your file that you want to enc- decrypt
                inputFilename = args[++i];
            else if ("-key".equals(args[i])) //this is for the key 
                myhexkey = args[++i];
            else if ("-dec".equals(args[i])) // dec is for decryption, when used will try to decrypt whatever is
                                             // given
                dec = true;
            else if ("-stat".equals(args[i])) // chi2 program
                stat = true;
        }

        HexFormat hex = HexFormat.of(); 
        byte[] keyBytes = hex.parseHex(myhexkey, 0, myhexkey.length()); // converts string to hex

        if (keyBytes.length == AE.getKey() / 8) // checks if the key is right size
        {
            System.out.println("OK");
        } else {
            System.out.println("ERR : keybytes = " + keyBytes.length);
            System.exit(1);
        }
        if (dec == true) // check if decryption is beeing requaiert
        {
            outputFilename = inputFilename + ".dec"; // adds to the end of the file .dec
            AE.decrypt(keyBytes, inputFilename, outputFilename); // calls decryption function
        } else {
            outputFilename = inputFilename + ".enc";// adds to the end of the file .enc
            AE.encrypt(keyBytes, inputFilename, outputFilename); // calls encryption function
        }
        if (stat == true) {
            File file = new File(outputFilename); //converts outputfilename to File object 
            AE.test(file);  //file object is handelt to the chi^2 program 

        }

    }

    public void encrypt(byte[] keyBytes, String inputFilename, String outputFilename)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IOException,
            InvalidAlgorithmParameterException {

        byte[] iv = new byte[12]; // set iv to 12 byts for GCM
        byte[] b = new byte[512]; // buffer
        int i;
        Random rand = new Random();
        rand.nextBytes(iv); // create random array of bytes using iv as the seed
        int tLen = 128; // tag length
        GCMParameterSpec gcmspec = new GCMParameterSpec(tLen, iv); // sets parameters for Cipher using the GCM mode
        SecretKeySpec k = new SecretKeySpec(keyBytes, "AES"); // constructs the secretkey
        Cipher cipher = Cipher.getInstance("AES/" + operationMode + "/NoPadding"); // this method returns a object that
                                                                                   // implemets AES
        cipher.init(Cipher.ENCRYPT_MODE, k, gcmspec); // initialize the cipher to encrypt data

        File fin = new File(inputFilename); // opens the given file
        FileInputStream fis = new FileInputStream(fin); // reads the file
        long time = System.currentTimeMillis();
        CipherInputStream cis = new CipherInputStream(fis, cipher); // reads and encrypts the content

        File fout = new File(outputFilename);// creates new output file
        FileOutputStream fos = new FileOutputStream(fout); // open file for writing

        fos.write(iv); // writes the iv into the file
        i = cis.read(b); // writes the encrypted content to buffer
        while (i != -1) { //

            fos.write(b, 0, i); // writes to file
            i = cis.read(b); // writes the encrypted content to buffer
        }
        long time2 = System.currentTimeMillis(); //second time record
        double time_final = time2 - time; //subtracted to get total time spend on Cipher
        time_final = time_final / 1000; //miliseconds to seconds
        String fsize =  fout.length()+""; //read out size of file
        
        double size = Double.parseDouble(fsize); //in bytes
        size = size *8; //to bits
        size = size / time_final; //to bps
        size = size /1000; //to kbps
        size = size /1000; //to Mbps
        
        System.out.println(String.format("%.3f",size)+ "MB/s");

        

        // close the read and write
        fos.close();
        cis.close();
        fis.close();

    }

    public void decrypt(byte[] keyBytes, String inputFilename, String outputFilename)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IOException,
            InvalidAlgorithmParameterException {

        int i; //
        byte[] iv = new byte[12]; // starting variables
        byte[] b = new byte[2048]; //

        File fin = new File(inputFilename); // opens file
        FileInputStream fis = new FileInputStream(fin); // reads data

        fis.read(iv, 0, iv.length); // reads iv data from file

        int tLen = 128; // tag length
        GCMParameterSpec gcmspec = new GCMParameterSpec(tLen, iv);// sets parameters for Cipher using the GCM mode
        SecretKeySpec k = new SecretKeySpec(keyBytes, "AES");// constructs the secretkey
        Cipher cipher = Cipher.getInstance("AES/" + operationMode + "/NoPadding");// this method returns a object that
                                                                                  // implemets AES
        cipher.init(Cipher.DECRYPT_MODE, k, gcmspec);// initialize the cipher to decrypt data

        File fout = new File(outputFilename); // creates new file
        FileOutputStream fos = new FileOutputStream(fout);// opens new file
        
        long time = System.currentTimeMillis(); //first time record
        
        CipherInputStream cis = new CipherInputStream(fis, cipher); // reads and decrypts the content

        // fos.write(iv);
        i = cis.read(b); // buffers decrypted content
        while (i != -1) { //
            fos.write(b, 0, i); // writes into file decrypted content
            i = cis.read(b); //
        }




        long time2 = System.currentTimeMillis(); //second time record
        double time_final = time2 - time; //subtracted to get total time spend on Cipher
        time_final = time_final / 1000; //miliseconds to seconds
        String fsize =  fout.length()+""; //read out size of file
        
        double size = Double.parseDouble(fsize); //in bytes
        size = size *8; //to bits
        size = size / time_final; //to bps
        size = size /1000; //to kbps
        size = size /1000; //to Mbps
       
        System.out.println(String.format("%.3f",size)+ "MB/s");





        // closes the read and write
        fis.close();
        fos.close();
        cis.close();

    }

    public void test(File file) throws IOException {

        // this code calculates chi-squared static to the file

        int[] counts = new int[256];
        try (InputStream in = new FileInputStream(file)) {
            int b;
            while ((b = in.read()) != -1) {
                counts[b]++;
            }
        }
        int n = (int) file.length();
        double e = n / 256.0;
        double chi2 = 0;
        for (int i = 0; i < 256; i++) {
            double d = counts[i] - e;
            chi2 += d * d;
        }
        chi2 /= e;
        System.out.println("x^2 = " + chi2);

    }
}
