package com.saiot.cms.core.commercial;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import com.saiot.cms.common.file.FileHandler;
import com.saiot.cms.common.file.FilesEx;
import com.saiot.cms.common.office.OpenOfficeConverter;
import com.saiot.cms.common.office.SwfConverter;
import com.saiot.cms.core.constant.Constants;
import com.saiot.cms.core.service.AttachmentService;

/**
 * 上传DOC文件。将doc文件转换成pdf，将pdf文件转化成swf文件。本功能在商业版中提供。
 * 
 * @author jiangjun
 *
 */
public class UploadDoc {
	public static void exec(AttachmentService attachmentService, FileHandler fileHandler, String pathname,
			String extension, String pdfPathname, String swfPathname, File file, String ip, Integer userId,
			Integer siteId) throws Exception {
		// 本功能在商业版中提供
		File pdfFrom = file;
		File pdfTemp = null;
		if (StringUtils.isNotBlank(pdfPathname)) {
			pdfTemp = FilesEx.getTempFile("pdf");
			OpenOfficeConverter.convert(file, pdfTemp, Constants.OPENOFFICE_PORT);
			pdfFrom = pdfTemp;
		}
		File swfTemp = FilesEx.getTempFile("swf");
		SwfConverter.pdf2swf(pdfFrom, swfTemp, Constants.SWFTOOLS_PDF2SWF, Constants.SWFTOOLS_LANGUAGEDIR);

		List<File> files = new ArrayList<File>();
		List<String> pathnames = new ArrayList<String>();
		files.add(file);
		pathnames.add(pathname);
		files.add(swfTemp);
		pathnames.add(swfPathname);
		if (pdfTemp != null) {
			files.add(pdfTemp);
			pathnames.add(pdfPathname);
		}
		fileHandler.storeFile(files, pathnames);
		attachmentService.save(swfPathname, swfTemp.length(), ip, userId, siteId);
		if (pdfTemp != null) {
			attachmentService.save(pdfPathname, swfTemp.length(), ip, userId, siteId);
		}
		for (File f : files) {
			FileUtils.deleteQuietly(f);
		}
	}
}
