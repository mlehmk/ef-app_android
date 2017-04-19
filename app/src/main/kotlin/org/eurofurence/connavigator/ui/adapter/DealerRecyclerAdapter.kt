package org.eurofurence.connavigator.ui.adapter

import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import io.swagger.client.model.Dealer
import org.eurofurence.connavigator.R
import org.eurofurence.connavigator.database.Database
import org.eurofurence.connavigator.net.imageService
import org.eurofurence.connavigator.ui.dialogs.DealerDialog
import org.eurofurence.connavigator.util.Formatter
import org.eurofurence.connavigator.util.TouchVibrator
import org.eurofurence.connavigator.util.delegators.view
import org.eurofurence.connavigator.util.extensions.applyOnRoot
import org.eurofurence.connavigator.util.extensions.get
import org.jetbrains.anko.*

/**
 * Created by David on 15-5-2016.
 */
class DealerDataHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    val dealerName: TextView by view()
    val dealerSubText: TextView by view()
    val dealerPreviewImage: ImageView by view()
    val layout: LinearLayout by view()
}

class DealerRecyclerAdapter(val effective_events: List<Dealer>, val database: Database, val fragment: Fragment) : RecyclerView.Adapter<DealerDataHolder>() {
    override fun getItemCount(): Int {
        return effective_events.count()
    }

    override fun onBindViewHolder(holder: DealerDataHolder, position: Int) {
        val dealer = effective_events[position]
        val vibrator = TouchVibrator(database.context)

        holder.dealerName.text = Formatter.dealerName(dealer)
        holder.dealerSubText.text = dealer.shortDescription ?: "This dealer did not provide a short description"

        // If no dealer preview was provided, load the YCH icon
        if (database.imageDb[dealer.artistThumbnailImageId] != null) {
            imageService.load(database.imageDb[dealer.artistThumbnailImageId], holder.dealerPreviewImage, false)
        } else {
            holder.dealerPreviewImage.setImageDrawable(ContextCompat.getDrawable(database.context, R.drawable.dealer_black))
        }

        holder.layout.setOnClickListener {
            fragment.applyOnRoot { navigateToDealer(dealer) }
            vibrator.long().let { true }
        }

        holder.layout.setOnLongClickListener {
            DealerDialog(dealer).show(fragment.childFragmentManager, "Dealer menu")
            vibrator.long().let { true }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DealerDataHolder =
            DealerDataHolder(DealerListItemUI().createView(AnkoContext.Companion.create(parent.context, parent)))
}

class DealerListItemUI : AnkoComponent<ViewGroup> {
    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        linearLayout {
            lparams(width = matchParent, height = wrapContent)
            backgroundResource = R.color.cardview_light_background
            id = R.id.layout
            imageView {
                padding = dip(5)
                scaleType = ImageView.ScaleType.FIT_CENTER
                id = R.id.dealerPreviewImage
            }.lparams(width = dip(75), height = dip(75))
            verticalLayout {
                padding = dip(10)
                textView {
                    setTextAppearance(android.R.style.TextAppearance_Large)
                    id = R.id.dealerName
                }
                textView {
                    setTextAppearance(android.R.style.TextAppearance_Small)
                    id = R.id.dealerSubText
                }
            }
        }
    }
}