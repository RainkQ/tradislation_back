package tk.tnicy.tradislation.Controller;

import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

@RestController
public class PicController {





    @GetMapping("/pic/{chi}")
    public String getPic(@PathVariable("chi") String chi) {
        String ret = getImageBinary("tradislation_pic/" + chi + ".png");
        if (ret!=null&&!ret.isEmpty()) {
            return getImageBinary("tradislation_pic/" + chi + ".png");
        }
        return "";
    }

    static String getImageBinary(String address){
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
        return  ret;// 返回Base64编码过的字节数组字符串
    }
}
