package com.whombang.app.adapter;

import android.content.Context;
import android.widget.RadioButton;
import android.widget.TextView;

import com.whombang.app.R;
import com.whombang.app.common.base.BaseViewHolder;
import com.whombang.app.entity.ConsigneeEntity;

import java.util.List;

/**
 * 收货人地址适配器
 * Created by sundy.jiang on 2017/12/11.
 */

public class ConsigneeAddressAdapter extends SimpleAdapter<ConsigneeEntity>{
    private TextView consigneeName ;
    private TextView consigneePhone ;
    private TextView consigneeAddress ;
    private TextView checkText ;
    private RadioButton isCheck ;
    private TextView edit ;
    private TextView delete ;
    public ConsigneeAddressAdapter(Context context, List<ConsigneeEntity> mDatas, int resId) {
        super(context, mDatas, resId);
    }

    @Override
    public void bindData(BaseViewHolder holder, ConsigneeEntity consigneeMsg, int position) {
        consigneeName = holder.findTextView(R.id.consignee_name) ;
        consigneePhone = holder.findTextView(R.id.consignee_phone) ;
        consigneeAddress = holder.findTextView(R.id.consignee_address) ;
        checkText = holder.findTextView(R.id.radio_selectedText) ;
        isCheck = holder.findRadioButton(R.id.radio_selected) ;
        edit = holder.findTextView(R.id.edite_address) ;
        delete = holder.findTextView(R.id.delete_address) ;

        isCheck.setChecked(consigneeMsg.isDefault());
        consigneeName.setText(consigneeMsg.getConsignee());
        consigneePhone.setText(showPhone(consigneeMsg.getPhone()));
        consigneeAddress.setText(consigneeMsg.getAddr());
        checkText.setText(consigneeMsg.isDefault() ? "默认地址" : "设为默认");
    }
    private String showPhone(String phone){
        return phone.substring(0 ,3) + "*****" + phone.substring(phone.length()-3) ;
    }
}
