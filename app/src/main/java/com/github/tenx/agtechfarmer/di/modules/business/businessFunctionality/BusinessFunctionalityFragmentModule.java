package com.github.tenx.agtechfarmer.di.modules.business.businessFunctionality;

import com.github.tenx.agtechfarmer.ui.business.funcnatilies.myarticles.BusinessMyArticleFragment;
import com.github.tenx.agtechfarmer.ui.business.funcnatilies.myProducts.BusinessMyProductsFragment;
import com.github.tenx.agtechfarmer.ui.business.funcnatilies.appointments.BusinessAppointmentFragment;
import com.github.tenx.agtechfarmer.ui.business.funcnatilies.articles.BusinessArticlesFragment;
import com.github.tenx.agtechfarmer.ui.business.funcnatilies.newArticle.BusinessNewArticleFragment;
import com.github.tenx.agtechfarmer.ui.business.funcnatilies.newProduct.BusinessNewProductFragment;
import com.github.tenx.agtechfarmer.ui.business.funcnatilies.notification.NotificationsFragment;
import com.github.tenx.agtechfarmer.ui.business.funcnatilies.questions.BusinessQuestionsFragment;
import com.github.tenx.agtechfarmer.ui.business.funcnatilies.shop.BusinessShopFragment;
import com.github.tenx.agtechfarmer.ui.business.funcnatilies.singleArticle.BusSingleArticleFragment;
import com.github.tenx.agtechfarmer.ui.business.funcnatilies.singleItemShop.BusSingleItemShopFragment;
import com.github.tenx.agtechfarmer.ui.business.funcnatilies.singleNotification.BusSingleNotificationFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class BusinessFunctionalityFragmentModule {

    @ContributesAndroidInjector(modules = {})
    abstract BusinessMyArticleFragment bindBusAddArticleFragment();

    @ContributesAndroidInjector(modules = {})
    abstract BusinessMyProductsFragment bindBusAddProductFrag();

    @ContributesAndroidInjector(modules = {})
    abstract BusinessAppointmentFragment bindBusAppointmentFrag();

    @ContributesAndroidInjector(modules = {})
    abstract BusinessArticlesFragment bindBusArticlesFrag();

    @ContributesAndroidInjector(modules = {})
    abstract BusinessQuestionsFragment bindBusQuestionsFrag();


    @ContributesAndroidInjector
    abstract BusinessShopFragment bindBusShopFrag();

    @ContributesAndroidInjector
    abstract BusSingleItemShopFragment bindBusSingleItemFrag();

    @ContributesAndroidInjector
    abstract BusSingleArticleFragment bindBusSingleArticleFrag();

    @ContributesAndroidInjector
    abstract BusinessNewArticleFragment bindBusNewArticleFrag();

    @ContributesAndroidInjector
    abstract BusinessNewProductFragment bindBusNewProductFrag();
    @ContributesAndroidInjector
    abstract NotificationsFragment bindNotificationsFragment();

    @ContributesAndroidInjector
    abstract BusSingleNotificationFragment bindBusSingleNotificationFragment();


}

