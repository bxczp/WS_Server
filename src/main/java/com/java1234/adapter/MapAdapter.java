package com.java1234.adapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.java1234.entity.MyRole;
import com.java1234.entity.Role;

public class MapAdapter extends XmlAdapter<MyRole[], Map<String,List<Role>>>{

	/**
	 * ÊÊÅä×ª»» MyRole[] -> Map<String, List<Role>>
	 */
	@Override
	public Map<String, List<Role>> unmarshal(MyRole[] v) throws Exception {
		Map<String, List<Role>> map=new HashMap<String,List<Role>>();
		for(int i=0;i<v.length;i++){
			MyRole r=v[i];
			map.put(r.getKey(), r.getValue());
		}
		return map;
	}

	/**
	 * ÊÊÅä×ª»» Map<String, List<Role>> -> MyRole[]
	 */
	@Override
	public MyRole[] marshal(Map<String, List<Role>> v) throws Exception {
		MyRole[] roles=new MyRole[v.size()];
		int i=0;
		for(String key:v.keySet()){
			roles[i]=new MyRole();
			roles[i].setKey(key);
			roles[i].setValue(v.get(key));
			i++;
		}
		return roles;
	}

}
