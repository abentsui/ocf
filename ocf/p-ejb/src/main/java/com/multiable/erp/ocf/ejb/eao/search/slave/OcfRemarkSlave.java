package com.multiable.erp.ocf.ejb.eao.search.slave;

import javax.ejb.Local;
import javax.ejb.Stateless;

import com.multiable.core.ejb.eao.bean.search.SearchSlave;
import com.multiable.core.ejb.eao.bean.search.SearchSlaveAdapter;
import com.multiable.core.share.meta.search.StParameter;
import com.multiable.erp.core.share.util.MacUtil;
import com.multiable.erp.ocf.share.OcfStaticVar.OcfSLAVE;

@Stateless(name = OcfSLAVE.OcfRemarkSlave)
@Local(SearchSlave.class)
public class OcfRemarkSlave extends SearchSlaveAdapter {

	@Override
	public void beforeDatalookup(StParameter param) {
		if (MacUtil.isIn(param.getStSearch(), "ocfRem")) {
			param.addExtraField("desc");
		}
	}
}
