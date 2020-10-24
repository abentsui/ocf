package com.multiable.erp.ocf.ireport.provider.dn;

import com.multiable.core.ejb.ds.MacQuery;
import com.multiable.core.share.data.ireport.CawReportDataSet;
import com.multiable.erp.core.ejb.ireport.MacModuleProvider;
import com.multiable.erp.core.share.util.MacReportUtil;
import com.multiable.erp.ocf.share.data.ireport.dn.OcfDnCardJrDto;

public class OcfDnSmallCardProvider extends MacModuleProvider {
	@Override
	public void initReportStru(CawReportDataSet reData) {
		reData.setQuery(0);
		int i = -1;
		i = MacReportUtil.setAlias(reData, i, "maindn", "maindn");
	}

	@Override
	public void adjustData(CawReportDataSet reData) {
		super.adjustData(reData);
		OcfDnCardJrDto jrDto = (OcfDnCardJrDto) getReportDto();
		handleHtmlField(reData, jrDto);

	}

	@Override
	public CawReportDataSet genIdsData() {
		super.genIdsData();

		OcfDnCardJrDto jrDto = (OcfDnCardJrDto) getReportDto();
		String sql = "{CALL prtocfdnsmall('" + jrDto.getMainIdString() + "')}";
		MacQuery query = new MacQuery();
		query.setQuery(sql);
		return fillAndAdjustData(query);
	}
}
