/**
 * Odoo, Open Source Management Solution
 * Copyright (C) 2012-today Odoo SA (<http:www.odoo.com>)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http:www.gnu.org/licenses/>
 *
 * Created on 13/2/15 4:16 PM
 */
package com.odoo.config;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.odoo.core.utils.OControls;
import com.odoo.R;
import com.odoo.widgets.slider.SliderItem;
import com.odoo.widgets.slider.SliderPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class IntroSliderItems implements SliderPagerAdapter.SliderBuilderListener, View.OnClickListener {
    public static final String TAG = IntroSliderItems.class.getSimpleName();
    private Context mContext;

    public List<SliderItem> getItems() {
        List<SliderItem> items = new ArrayList<>();
        items.add(new SliderItem("Planifica tu Dia", "Madketing Mobile te mantiene organizado, concentrado y mas productivo",
                R.drawable.slide_1, this)
                .putExtra("sub_title", "Organiza todo en un solo lugar"));
        items.add(new SliderItem("Informacion de llamadas", "Obtiene informacion del Cliente y de la reciente Oportunidad, antes de levantar el telefono.",
                R.drawable.slide_3, this)
                .putExtra("sub_title", "Mira quien llama"));
        items.add(new SliderItem("Recordatorios", "Utiliza recordatorios para asegurarte que nada se te olvide",
                R.drawable.slide_4, this)
                .putExtra("sub_title", "Recordatorio con acciones rapidas"));
        items.add(new SliderItem("Funcionalidades Simples", "Madketing Mobile ofrece funcionalidades simples y al alcance de tu mano",
                R.drawable.slide_5, this)
                .putExtra("sub_title", "Variedad de opciones utiles"));
        items.add(new SliderItem("Administra operaciones", "Crea/Edita items y operaciones facilmente",
                R.drawable.slide_6, this)
                .putExtra("sub_title", "Administra tus operaciones facilmente!"));
        items.add(new SliderItem("", "Todos los datos se sincronizan con el servidor cuando te conectas a internet",
                R.drawable.no_network, this)
                .putExtra("sub_title", "Funciona sin conexion!"));
        items.add(new SliderItem("Comencemos", "",
                R.drawable.odoo_shaded, this)
                .putExtra("sub_title", "Comenzar a explorar Madketing Mobile"));
        return items;
    }

    @Override
    public View getCustomView(Context context, SliderItem item, ViewGroup parent) {
        mContext = context;
        View view = LayoutInflater.from(context).inflate(R.layout.base_intro_slider_view, parent, false);
        OControls.setText(view, R.id.big_title, item.getTitle());
        OControls.setImage(view, R.id.slider_image, item.getImagePath());
        OControls.setText(view, R.id.sub_title, item.getExtras().get("sub_title").toString());
        OControls.setText(view, R.id.description, item.getContent());
        if (item.getImagePath() == R.drawable.odoo_shaded) {
            OControls.setGone(view, R.id.description);
            OControls.setVisible(view, R.id.btnSliderFinish);
            OControls.setText(view, R.id.btnSliderFinish, "ENTENDIDO, VAMOS!");
            view.findViewById(R.id.btnSliderFinish).setOnClickListener(this);
        } else {
            OControls.setVisible(view, R.id.description);
            OControls.setGone(view, R.id.btnSliderFinish);
        }
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnSliderFinish) {
            ((Activity) mContext).finish();
        }
    }
}
