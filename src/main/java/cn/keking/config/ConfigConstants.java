package cn.keking.config;

import cn.keking.utils.ConfigUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author: chenjh
 * @since: 2019/4/10 17:22
 */
@Component
public class ConfigConstants {

    static {
        //pdfbox兼容低版本jdk
        System.setProperty("sun.java2d.cmm", "sun.java2d.cmm.kcms.KcmsServiceProvider");
    }

    private static Boolean cacheEnabled;
    private static String[] simTexts = {};
    private static String[] medias = {};
    private static String[] convertMedias = {};
    private static String mediaConvertDisable;
    private static String officePreviewType;
    private static String officePreviewSwitchDisabled;
    private static String ftpUsername;
    private static String ftpPassword;
    private static String ftpControlEncoding;
    private static String baseUrl;

    private static String baseUrl4Mobile;
    private static String fileDir = ConfigUtils.getHomePath() + File.separator + "file" + File.separator;
    private static String localPreviewDir;
    private static CopyOnWriteArraySet<String> trustHostSet;
    private static String pdfPresentationModeDisable;
    private static String pdfOpenFileDisable;
    private static String pdfPrintDisable;
    private static String pdfDownloadDisable;
    private static String pdfBookmarkDisable;
    private static Boolean fileUploadDisable;
    private static String tifPreviewType;
    private static String beian;
    private static String[] prohibit = {};
    private static String size;
    private static String password;
    private static int pdf2JpgDpi;
    private static String officeTypeWeb;
    private static Boolean deleteSourceFile;

    public static final String DEFAULT_CACHE_ENABLED = "true";
    public static final String DEFAULT_TXT_TYPE = "txt,html,htm,asp,jsp,xml,json,properties,md,gitignore,log,java,py,c,cpp,sql,sh,bat,m,bas,prg,cmd";
    public static final String DEFAULT_MEDIA_TYPE = "mp3,wav,mp4,flv";
    public static final String DEFAULT_OFFICE_PREVIEW_TYPE = "image";
    public static final String DEFAULT_OFFICE_PREVIEW_SWITCH_DISABLED = "false";
    public static final String DEFAULT_FTP_USERNAME = null;
    public static final String DEFAULT_FTP_PASSWORD = null;
    public static final String DEFAULT_FTP_CONTROL_ENCODING = "UTF-8";
    public static final String DEFAULT_BASE_URL = "default";
    public static final String DEFAULT_FILE_DIR_VALUE = "default";
    public static final String DEFAULT_LOCAL_PREVIEW_DIR_VALUE = "default";
    public static final String DEFAULT_TRUST_HOST = "default";
    public static final String DEFAULT_PDF_PRESENTATION_MODE_DISABLE = "true";
    public static final String DEFAULT_PDF_OPEN_FILE_DISABLE = "true";
    public static final String DEFAULT_PDF_PRINT_DISABLE = "true";
    public static final String DEFAULT_PDF_DOWNLOAD_DISABLE = "true";
    public static final String DEFAULT_PDF_BOOKMARK_DISABLE = "true";
    public static final String DEFAULT_FILE_UPLOAD_DISABLE = "false";
    public static final String DEFAULT_TIF_PREVIEW_TYPE = "tif";
    public static final String DEFAULT_BEIAN = "无";
    public static final String DEFAULT_SIZE = "500MB";
    public static final String DEFAULT_PROHIBIT = "exe,dll";
    public static final String DEFAULT_PASSWORD = "123456";
    public static final String DEFAULT_PDF2_JPG_DPI = "105";
    public static final String DEFAULT_OFFICE_TYPE_WEB = "web";
    public static final String DEFAULT_DELETE_SOURCE_FILE = "true";

    public static Boolean isCacheEnabled() {
        return cacheEnabled;
    }

    @Value("${cache.enabled:true}")
    public void setCacheEnabled(String cacheEnabled) {
        setCacheEnabledValueValue(Boolean.parseBoolean(cacheEnabled));
    }

    public static void setCacheEnabledValueValue(Boolean cacheEnabled) {
        ConfigConstants.cacheEnabled = cacheEnabled;
    }

    public static String[] getSimText() {
        return simTexts;
    }

    @Value("${simText:txt,html,htm,asp,jsp,xml,json,properties,md,gitignore,log,java,py,c,cpp,sql,sh,bat,m,bas,prg,cmd}")
    public void setSimText(String simText) {
        String[] simTextArr = simText.split(",");
        setSimTextValue(simTextArr);
    }

    public static void setSimTextValue(String[] simText) {
        ConfigConstants.simTexts = simText;
    }

    public static String[] getMedia() {
        return medias;
    }

    @Value("${media:mp3,wav,mp4,flv}")
    public void setMedia(String media) {
        String[] mediaArr = media.split(",");
        setMediaValue(mediaArr);
    }

    public static void setMediaValue(String[] Media) {
        ConfigConstants.medias = Media;
    }

    public static String[] getConvertMedias() {
        return convertMedias;
    }

    @Value("${convertMedias:avi,mov,wmv,mkv,3gp,rm}")
    public void setConvertMedias(String convertMedia) {
        String[] mediaArr = convertMedia.split(",");
        setConvertMediaValue(mediaArr);
    }

    public static void setConvertMediaValue(String[] ConvertMedia) {
        ConfigConstants.convertMedias = ConvertMedia;
    }

    public static String getMediaConvertDisable() {
        return mediaConvertDisable;
    }


    @Value("${media.convert.disable:true}")
    public void setMediaConvertDisable(String mediaConvertDisable) {
        setMediaConvertDisableValue(mediaConvertDisable);
    }
    public static void setMediaConvertDisableValue(String mediaConvertDisable) {
        ConfigConstants.mediaConvertDisable = mediaConvertDisable;
    }

    public static String getOfficePreviewType() {
        return officePreviewType;
    }

    @Value("${office.preview.type:image}")
    public void setOfficePreviewType(String officePreviewType) {
        setOfficePreviewTypeValue(officePreviewType);
    }

    public static void setOfficePreviewTypeValue(String officePreviewType) {
        ConfigConstants.officePreviewType = officePreviewType;
    }

    public static String getFtpUsername() {
        return ftpUsername;
    }

    @Value("${ftp.username:}")
    public void setFtpUsername(String ftpUsername) {
        setFtpUsernameValue(ftpUsername);
    }

    public static void setFtpUsernameValue(String ftpUsername) {
        ConfigConstants.ftpUsername = ftpUsername;
    }

    public static String getFtpPassword() {
        return ftpPassword;
    }

    @Value("${ftp.password:}")
    public void setFtpPassword(String ftpPassword) {
        setFtpPasswordValue(ftpPassword);
    }

    public static void setFtpPasswordValue(String ftpPassword) {
        ConfigConstants.ftpPassword = ftpPassword;
    }

    public static String getFtpControlEncoding() {
        return ftpControlEncoding;
    }

    @Value("${ftp.control.encoding:UTF-8}")
    public void setFtpControlEncoding(String ftpControlEncoding) {
        setFtpControlEncodingValue(ftpControlEncoding);
    }

    public static void setFtpControlEncodingValue(String ftpControlEncoding) {
        ConfigConstants.ftpControlEncoding = ftpControlEncoding;
    }

    public static String getBaseUrl() {
        return baseUrl;
    }

    @Value("${base.url:default}")
    public void setBaseUrl(String baseUrl) {
        setBaseUrlValue(baseUrl);
    }

    public static void setBaseUrlValue(String baseUrl) {
        ConfigConstants.baseUrl = baseUrl;
    }

    public static String getBaseUrl4Mobile() {
        return baseUrl4Mobile;
    }

    @Value("${base.url.mobile:default}")
    public void setBaseUrl4Mobile(String baseUrl4Mobile) {
        setBaseUrl4MobileValue(baseUrl4Mobile);
    }

    public static void setBaseUrl4MobileValue(String baseUrl4Mobile) {
        ConfigConstants.baseUrl4Mobile = baseUrl4Mobile;
    }


    public static String getFileDir() {
        return fileDir;
    }

    @Value("${file.dir:default}")
    public void setFileDir(String fileDir) {
        setFileDirValue(fileDir);
    }

    public static void setFileDirValue(String fileDir) {
        if (!DEFAULT_FILE_DIR_VALUE.equalsIgnoreCase(fileDir)) {
            if (!fileDir.endsWith(File.separator)) {
                fileDir = fileDir + File.separator;
            }
            ConfigConstants.fileDir = fileDir;
        }
    }

    public static String getLocalPreviewDir() {
        return localPreviewDir;
    }

    @Value("${local.preview.dir:default}")
    public void setLocalPreviewDir(String localPreviewDir) {
        setLocalPreviewDirValue(localPreviewDir);
    }

    public static void setLocalPreviewDirValue(String localPreviewDir) {
        if (!DEFAULT_LOCAL_PREVIEW_DIR_VALUE.equals(localPreviewDir)) {
            if (!localPreviewDir.endsWith(File.separator)) {
                localPreviewDir = localPreviewDir + File.separator;
            }
        }
        ConfigConstants.localPreviewDir = localPreviewDir;
    }

    @Value("${trust.host:default}")
    public void setTrustHost(String trustHost) {
        setTrustHostValue(trustHost);
    }

    public static void setTrustHostValue(String trustHost) {
        CopyOnWriteArraySet<String> trustHostSet;
        if (DEFAULT_TRUST_HOST.equalsIgnoreCase(trustHost)) {
            trustHostSet = new CopyOnWriteArraySet<>();
        } else {
            String[] trustHostArray = trustHost.toLowerCase().split(",");
            trustHostSet = new CopyOnWriteArraySet<>(Arrays.asList(trustHostArray));
            setTrustHostSet(trustHostSet);
        }
        setTrustHostSet(trustHostSet);
    }

    public static Set<String> getTrustHostSet() {
        return trustHostSet;
    }

    private static void setTrustHostSet(CopyOnWriteArraySet<String> trustHostSet) {
        ConfigConstants.trustHostSet = trustHostSet;
    }

    public static String getPdfPresentationModeDisable() {
        return pdfPresentationModeDisable;
    }

    @Value("${pdf.presentationMode.disable:true}")
    public void setPdfPresentationModeDisable(String pdfPresentationModeDisable) {
        setPdfPresentationModeDisableValue(pdfPresentationModeDisable);
    }

    public static void setPdfPresentationModeDisableValue(String pdfPresentationModeDisable) {
        ConfigConstants.pdfPresentationModeDisable = pdfPresentationModeDisable;
    }

    public static String getPdfOpenFileDisable() {
        return pdfOpenFileDisable;
    }

    @Value("${pdf.openFile.disable:true}")
    public void setPdfOpenFileDisable(String pdfOpenFileDisable) {
        setPdfOpenFileDisableValue(pdfOpenFileDisable);
    }
    public static void setPdfOpenFileDisableValue(String pdfOpenFileDisable) {
        ConfigConstants.pdfOpenFileDisable = pdfOpenFileDisable;
    }

    public static String getPdfPrintDisable() {
        return pdfPrintDisable;
    }
    @Value("${pdf.print.disable:true}")
    public void setPdfPrintDisable(String pdfPrintDisable) {
        setPdfPrintDisableValue(pdfPrintDisable);
    }
    public static void setPdfPrintDisableValue(String pdfPrintDisable) {
        ConfigConstants.pdfPrintDisable = pdfPrintDisable;
    }

    public static String getPdfDownloadDisable() {
        return pdfDownloadDisable;
    }

    @Value("${pdf.download.disable:true}")
    public void setPdfDownloadDisable(String pdfDownloadDisable) {
        setPdfDownloadDisableValue(pdfDownloadDisable);
    }
    public static void setPdfDownloadDisableValue(String pdfDownloadDisable) {
        ConfigConstants.pdfDownloadDisable = pdfDownloadDisable;
    }

    public static String getPdfBookmarkDisable() {
        return pdfBookmarkDisable;
    }
    @Value("${pdf.bookmark.disable:true}")
    public void setPdfBookmarkDisable(String pdfBookmarkDisable) {
        setPdfBookmarkDisableValue(pdfBookmarkDisable);
    }
    public static void setPdfBookmarkDisableValue(String pdfBookmarkDisable) {
        ConfigConstants.pdfBookmarkDisable = pdfBookmarkDisable;
    }

    public static String getOfficePreviewSwitchDisabled() {
        return officePreviewSwitchDisabled;
    }
    @Value("${office.preview.switch.disabled:true}")
    public void setOfficePreviewSwitchDisabled(String officePreviewSwitchDisabled) {
        ConfigConstants.officePreviewSwitchDisabled = officePreviewSwitchDisabled;
    }
    public static void setOfficePreviewSwitchDisabledValue(String officePreviewSwitchDisabled) {
        ConfigConstants.officePreviewSwitchDisabled = officePreviewSwitchDisabled;
    }

    public static Boolean getFileUploadDisable() {
        return fileUploadDisable;
    }

    @Value("${file.upload.disable:false}")
    public void setFileUploadDisable(Boolean fileUploadDisable) {
        setFileUploadDisableValue(fileUploadDisable);
    }

    public static void setFileUploadDisableValue(Boolean fileUploadDisable) {
        ConfigConstants.fileUploadDisable = fileUploadDisable;
    }


    public static String getTifPreviewType() {
        return tifPreviewType;
    }

    @Value("${tif.preview.type:tif}")
    public void setTifPreviewType(String tifPreviewType) {
        setTifPreviewTypeValue(tifPreviewType);
    }

    public static void setTifPreviewTypeValue(String tifPreviewType) {
        ConfigConstants.tifPreviewType = tifPreviewType;
    }

    public static String getBeian() {
        return beian;
    }
    @Value("${beian:default}")
    public void setBeian(String beian) {
        setBeianValue(beian);
    }
    public static void setBeianValue(String beian) {
        ConfigConstants.beian = beian;
    }
    public static String[] getProhibit() {
        return prohibit;
    }
    @Value("${prohibit:exe,dll}")
    public void setProhibit(String prohibit) {
        String[] prohibitArr = prohibit.split(",");
        setProhibitValue(prohibitArr);
    }

    public static void setProhibitValue(String[] prohibit) {
        ConfigConstants.prohibit = prohibit;
    }
    public static String maxSize() {
        return size;
    }
    @Value("${spring.servlet.multipart.max-file-size:500MB}")
    public void setSize(String size) {
        setSizeValue(size);
    }
    public static void setSizeValue(String size) {
        ConfigConstants.size = size;
    }

    public static String getPassword() {
        return password;
    }
    @Value("${delete.password:123456}")
    public void setPassword(String password) {
        setPasswordValue(password);
    }
    public static void setPasswordValue(String password) {
        ConfigConstants.password = password;
    }


    public static int getPdf2JpgDpi() {
        return pdf2JpgDpi;
    }
    @Value("${pdf2jpg.dpi:105}")
    public void pdf2JpgDpi(int pdf2JpgDpi) {
        setPdf2JpgDpiValue(pdf2JpgDpi);
    }
    public static void setPdf2JpgDpiValue(int pdf2JpgDpi) {
        ConfigConstants.pdf2JpgDpi = pdf2JpgDpi;
    }

    public static String getOfficeTypeWeb() {
        return officeTypeWeb;
    }
    @Value("${office.type.web:web}")
    public void setOfficeTypeWeb(String officeTypeWeb) {
        setOfficeTypeWebValue(officeTypeWeb);
    }
    public static void setOfficeTypeWebValue(String officeTypeWeb) {
        ConfigConstants.officeTypeWeb = officeTypeWeb;
    }


    public static Boolean getDeleteSourceFile() {
        return deleteSourceFile;
    }

    @Value("${delete.source.file:true}")
    public void setDeleteSourceFile(Boolean deleteSourceFile) {
        setDeleteSourceFileValue(deleteSourceFile);
    }

    public static void setDeleteSourceFileValue(Boolean deleteSourceFile) {
        ConfigConstants.deleteSourceFile = deleteSourceFile;
    }

}