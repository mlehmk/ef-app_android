package org.eurofurence.connavigator.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.github.chrisbanes.photoview.PhotoView
import io.swagger.client.model.KnowledgeEntryRecord
import org.eurofurence.connavigator.R
import org.eurofurence.connavigator.database.HasDb
import org.eurofurence.connavigator.database.lazyLocateDb
import org.eurofurence.connavigator.net.imageService
import org.eurofurence.connavigator.tracking.Analytics
import org.eurofurence.connavigator.util.Formatter
import org.eurofurence.connavigator.util.extensions.*
import org.jetbrains.anko.*
import us.feras.mdv.MarkdownView


/**
 * Views an info based on an ID passed to the intent
 */
class FragmentViewInfo() : Fragment(), HasDb {
    override val db by lazyLocateDb()

    val ui by lazy { InfoUi() }

    /**
     * Constructs the info view with an assigned bundle
     */
    constructor(knowledgeEntry: KnowledgeEntryRecord) : this() {
        arguments = Bundle()
        arguments.jsonObjects["knowledgeEntry"] = knowledgeEntry
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        ui.createView(AnkoContext.create(context.applicationContext, container!!))

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Analytics.screen(activity, "Info Specific")


        applyOnRoot { changeTitle("Information") }
        // Get info if it exists
        if ("knowledgeEntry" in arguments) {
            val knowledgeEntry: KnowledgeEntryRecord = arguments.jsonObjects["knowledgeEntry"]

            Analytics.event(Analytics.Category.INFO, Analytics.Action.OPENED, knowledgeEntry.title)

            // Set the properties of the view
            ui.title.text = knowledgeEntry.title
            ui.text.loadMarkdown(knowledgeEntry.text)

            if (knowledgeEntry.imageIds.isNotEmpty()) {
                imageService.load(db.images[knowledgeEntry.imageIds.first()], ui.image, showHide = false)
            } else {
                ui.image.visibility = View.GONE
            }

            for (url in knowledgeEntry.links) {
                val button = Button(context)
                button.text = url.name
                button.setOnClickListener {
                    Analytics.event(Analytics.Category.INFO, Analytics.Action.LINK_CLICKED, url.target)
                    context.browse(url.target)
                }

                ui.layout.addView(button)
            }
        }
    }
}

class InfoUi : AnkoComponent<ViewGroup> {
    lateinit var layout: LinearLayout
    lateinit var image: PhotoView
    lateinit var title: TextView
    lateinit var text: MarkdownView
    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        scrollView {
            lparams(matchParent, matchParent)
            backgroundResource = R.color.cardview_light_background

            layout = verticalLayout {
                image = photoView {
                    backgroundResource = R.drawable.placeholder_event
                    scaleType = ImageView.ScaleType.CENTER_CROP
                }.lparams(matchParent, dip(300))

                title = themedTextView(R.style.AppTheme_Header) {
                    lparams(matchParent, wrapContent)
                    setTextAppearance(ctx, android.R.style.TextAppearance_Large_Inverse)
                }

                text = markdownView {
                    lparams(matchParent, wrapContent)
                }
            }
        }
    }

}