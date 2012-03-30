package be.cytomine

import org.springframework.web.multipart.commons.CommonsMultipartResolver
import javax.servlet.http.HttpServletRequest
import org.springframework.web.multipart.MaxUploadSizeExceededException
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest
import org.springframework.web.multipart.MultipartHttpServletRequest
import org.springframework.util.LinkedMultiValueMap

/**
 * Cytomine @ GIGA-ULG
 * User: stevben
 * Date: 31/01/12
 * Time: 10:43
 */

public class CytomineMultipartHttpServletRequest extends CommonsMultipartResolver {

    static final String FILE_SIZE_EXCEEDED_ERROR = "fileSizeExceeded"

    public MultipartHttpServletRequest resolveMultipart(HttpServletRequest request) {
        println "===MultipartHttpServletRequest==="
        try {
            println "===SUPER===MultipartHttpServletRequest==="
            return super.resolveMultipart(request)
        } catch (MaxUploadSizeExceededException e) {
            println "===CATCH===MultipartHttpServletRequest==="
            request.setAttribute(FILE_SIZE_EXCEEDED_ERROR, true)
            return new DefaultMultipartHttpServletRequest(request, new LinkedMultiValueMap(), [:])
        }
    }
}