package cn.keking;

 import cn.keking.model.FileAttribute;
 import cn.keking.model.FileType;
 import cn.keking.service.FileHandlerService;
import cn.keking.service.FilePreview;
import cn.keking.service.FilePreviewFactory;
import cn.keking.service.cache.CacheService;
import cn.keking.service.impl.OtherFilePreviewImpl;
import cn.keking.web.controller.OnlinePreviewController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
 import org.springframework.boot.test.context.SpringBootTest;
 import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;


 import static org.junit.jupiter.api.Assertions.assertEquals;
 import static org.mockito.ArgumentMatchers.any;
 import static org.mockito.ArgumentMatchers.anyString;
 import static org.mockito.Mockito.*;

//@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class OnlinePreviewControllerTest {

    @Mock
    private FilePreviewFactory filePreviewFactory;

    @Mock
    private FileHandlerService fileHandlerService;

    @Mock
    private CacheService cacheService;

    @Mock
    private OtherFilePreviewImpl otherFilePreview;

    @Mock
    private HttpServletRequest request;

    @Mock
    private Model model;

    @InjectMocks
    private OnlinePreviewController onlinePreviewController;

    @Test
    public void testOnlinePreview() {
        //http://127.0.0.1:8012/onlinePreview?mode=mb&url=aHR0cDovLzEyNy4wLjAuMTo4MDEyL2RlbW8vMjIyLnhsc3g%3D
        //http://127.0.0.1:8012/onlinePreview?url=aHR0cDovLzEyNy4wLjAuMTo4MDEyL2RlbW8vMjIyLnhsc3g%3D
        String url = "aHR0cDovLzEyNy4wLjAuMTo4MDEyL2RlbW8vMjIyLnhsc3g%3D";
        FileAttribute fileAttribute = new FileAttribute();
        fileAttribute.setType(  FileType.OFFICE);
        FilePreview filePreview = mock(FilePreview.class);

        when(fileHandlerService.getFileAttribute(anyString(), any())).thenReturn(fileAttribute);
        when(filePreviewFactory.get(any())).thenReturn(filePreview);
        when(filePreview.filePreviewHandle(anyString(), any(), any())).thenReturn("previewPage");

        String result = onlinePreviewController.onlinePreview(url, model, request);

        verify(fileHandlerService, times(1)).getFileAttribute(anyString(), any());
        verify(filePreviewFactory, times(1)).get(any());
        verify(filePreview, times(1)).filePreviewHandle(anyString(), any(), any());

        assertEquals("previewPage", result);
    }
}

