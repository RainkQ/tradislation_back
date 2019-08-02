package tk.tnicy.tradislation.Controller;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.nio.charset.StandardCharsets;

@RestController
public class PicController {


    static String getImageBinary(String address) {
        String imgFile = address;// 待处理的图片
        InputStream in = null;
        byte[] data = null;
        // 读取图片字节数组
        try {
            in = new FileInputStream(imgFile);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组Base64编码

        byte[] encode = Base64Utils.encode(data);
        String ret = new String(encode, StandardCharsets.UTF_8);
        return ret;// 返回Base64编码过的字节数组字符串
    }

    @GetMapping("/pic/{chi}")
    public String getPic(@PathVariable("chi") String chi) {
        String ret = getImageBinary("tradislation_pic/" + chi + ".png");
        if (ret != null && !ret.isEmpty()) {
            return getImageBinary("tradislation_pic/" + chi + ".png");
        }
        return "";
    }


    @GetMapping(value = "/img/{chi}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<Resource> getImgs(@PathVariable("chi") String chi) throws FileNotFoundException {
        InputStream inputStream = new FileInputStream(new File("tradislation_pic/" + chi + ".png"));
        InputStreamResource inputStreamResource = new InputStreamResource(inputStream);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(inputStreamResource, headers, HttpStatus.OK);
    }

    @GetMapping("/pic/search/{chi}")
    public int searchPicNumber(@PathVariable("chi") String chi) {
        int count = 0;
        String path = "tradislation_pic";        //要遍历的路径
        File file = new File(path);        //获取其file对象
        File[] fs = file.listFiles();    //遍历path下的文件和目录，放在File数组中
        assert fs != null;
        for (File f : fs) {                    //遍历File[]数组
            if (!f.isDirectory()) {    //若非目录(即文件)
                if (f.getName().startsWith(chi)) {
                    count++;
                }
            }
        }
        return count;
    }
}





