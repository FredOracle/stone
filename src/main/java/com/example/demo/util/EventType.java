package com.example.demo.util;

import javax.annotation.Resource;

import com.example.demo.business.DemoBusiness;

public enum EventType implements EventOption {
	
	CREATE {
		@Override
		public String doEvent(DemoBusiness b) {
			// TODO Auto-generated method stub
			System.out.println("Create");
			return "Create";
		}

	},
	
	UPDATE {
		@Override
		public String doEvent(DemoBusiness b) {
			// TODO Auto-generated method stub
			System.out.println("Update");
			return "Update";
		}
	},
	
	DELETE {
		@Override
		public String doEvent(DemoBusiness b) {
			// TODO Auto-generated method stub
			System.out.println("Delete");
			return "Delete";
		}
	};
	
}
