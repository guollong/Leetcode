/**
 * Question description: The API: int read4(char *buf) reads 4 characters at a time from a file.
 *		The return value is the actual number of characters read. For example, it returns 3 if 
 *		there is only 3 characters left in the file.
 *
 *		By using the read4 API, implement the function int read(char *buf, int n) that reads n 
 *		characters from the file.
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: Facebook.
 */

/**
 * Progress...
 * Create Date: 06/15/2017
 */

// 我觉得这个题是个好题。。。。。(Follow up)
// Actually, this question may be more practical than it looks like at your first glimpse.
// In reality, hardware or system may have constraints for read from file system. eg. hardeware 
// DMA engine may fetch data 128 bytes from disk. another example is that loading 4-bytes 
// in aligned address should be obviously faster than load 1 byte 4 times. It is exactly same 
// as read4 problem.



/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        // buffer used to store the data read using read4.
        char[] buffer = new char[4];
        boolean endOfFile = false;
        int readBytes = 0;
        
        // If read bytes are greater than n or the buffer up to limit, return.
        while (readBytes < n && !endOfFile) {
            // read 4 or less bytes and store it into buffer. If the number of 
            // bytes is less than 4, it hit the limit of the buffer.
            int currReadBytes = read4(buffer);
            if (currReadBytes != 4) {
                endOfFile = true;
            }
            
            // move the data from buffer to the buf.
            int length = Math.min(n - readBytes, currReadBytes);
            for (int i = 0; i < length; i++) {
                buf[readBytes + i] = buffer[i];
            }
            readBytes += length;
        }
        return readBytes;
    }
}

